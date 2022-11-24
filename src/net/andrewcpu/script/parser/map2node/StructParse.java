package net.andrewcpu.script.parser.map2node;

import net.andrewcpu.halo.nodes.AllNodes;
import net.andrewcpu.halo.nodes.Node;
import net.andrewcpu.halo.nodes.nodes.variables.advanced.IISNode;
import net.andrewcpu.halo.nodes.nodes.variables.advanced.ISONode;
import net.andrewcpu.halo.nodes.nodes.variables.advanced.IVSONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.ObjectType;
import net.andrewcpu.halo.type.PlayerType;
import net.andrewcpu.script.parser.map2node.struct.ConstantValue;
import net.andrewcpu.script.parser.map2node.struct.FilledFunction;
import net.andrewcpu.script.parser.map2node.struct.HaloVariableReference;
import net.andrewcpu.script.parser.map2node.struct.InvocationCollection;
import net.andrewcpu.script.tokenizer.Token;
import net.andrewcpu.script.tokenizer.TokenType;
import net.andrewcpu.script.tokenizer.grammar.structures.*;
import net.andrewcpu.script.tokenizer.grammar.structures.structure2node.TypeNameReference;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.xml.crypto.Data;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class StructParse {

    public static Scope globalScope = new Scope(null);

    public static JSONObject parseEventDeclarationStructure(Scope parent, EventDeclarationStructure eventDeclarationStructure) {
        Scope scope = new Scope(parent);
        ItemList parameters = eventDeclarationStructure.getParameters();
        Object[][] splitParameters = parameters.split(TokenType.LIST_SEPARATOR);
        String eventName = eventDeclarationStructure.getEventDeclaration().getValue().substring(1); // remove the @
        DataType[] outputTypes = LookupNode.getOutputOfNode(eventName);


        JSONArray outputs = new JSONArray();
        int n = 0;
        for (Object[] o : splitParameters) {
            TypeNameReference typeNameReference = new TypeNameReference(outputTypes[n].getClass(), ((Token) o[0]).getValue());
            scope.declare(typeNameReference);
            outputs.add(typeNameReference.toJSON());
            n++;
        }
        JSONArray inputs = new JSONArray();
        JSONObject event = new JSONObject();
        event.put("type", eventName);
        event.put("output", outputs);
        event.put("input", inputs);
        event.put("next", parseBlockBody(scope, eventDeclarationStructure.getBody()));

        return event;
    }

    private static JSONObject parseBlockBody(Scope parent, BlockStructure body) {
        Scope scope = new Scope(parent);
        JSONObject root = null;
        JSONObject last = null;
        for (Object o : body.getChildren()) {
            JSONObject parsed = null;
            if(o instanceof IfElseStructure ifElseStructure) {
                parsed = parseIfStatement(scope, ifElseStructure);
            }
            else if(o instanceof ActionInvocation actionInvocation) {
                parsed = (JSONObject) parseActionInvocation(scope, actionInvocation);
            }
            else if(o instanceof Token token && token.getType() == TokenType.STATEMENT_END) {
                continue;
            }
            else if(o instanceof ForEachStructure forEachStructure) {
                parsed = parseForEachStructure(scope, forEachStructure);
            }
            else if(o instanceof ValueAssignmentStructure valueAssignmentStructure){
                parsed = parseVariableAssignmentOperator(scope, valueAssignmentStructure);
                //todo parse variable assignment structure
                System.out.println(parsed);
            }
            else{
                System.out.println("??? " + o);
            }
            if(parsed != null){
                if(root == null){
                    root = parsed;
                }
                if (last != null) {
//                    System.out.println(last);
                    if(last.get("type").toString().startsWith("ForEach")) {
                        ((JSONArray)last.get("output")).set(0 /* onCompletion */, parsed);
                    }
                    else{
                        last.put("next", parsed);
                    }
                }
                last = parsed;
            }
        }
        return root;
    }

    private static JSONObject parseForEachStructure(Scope parent, ForEachStructure forEachStructure) {
        Scope scope = new Scope(parent);
        Object[][] split = forEachStructure.getKeyValuePair().split(TokenType.LIST_SEPARATOR);
        List flat = flatten(forEachStructure.getParameters());
        flat = replaceReferences(scope, flat);
        JSONObject inputCondition = ((JSONObject) (parseList(scope, flat)).get(0));
        JSONObject condition = new JSONObject();
        TypeNameReference iteratingObject;
        if(inputCondition.get("returnType").equals("PlayersType")){
            //players
            condition.put("type", "ForEachPlayer");
            iteratingObject = new TypeNameReference(PlayerType.class, ((Token) split[0][0]).getValue());
        }
        else{
            //objects
            condition.put("type", "ForEachObject");
            iteratingObject = (new TypeNameReference(ObjectType.class, ((Token)split[0][0]).getValue()));

        }
        scope.declare(iteratingObject);
        TypeNameReference iteratingNumber = new TypeNameReference(NumberType.class, ((Token) split[1][0]).getValue());
        scope.declare(iteratingNumber);
        JSONArray outputs = new JSONArray();
        JSONArray inputs = new JSONArray();
        inputs.add(inputCondition);
        outputs.add(new JSONObject());
        outputs.add(parseBlockBody(scope, forEachStructure.getBody()));
        outputs.add(iteratingObject.toJSON());
        outputs.add(iteratingNumber.toJSON());
        condition.put("output", outputs);
        condition.put("input", inputs);

        return condition;
    }


    public static JSONObject parseIfStatement(Scope scope, IfElseStructure structure) {
        List flat = flatten(structure.getIfConditions());
        flat = replaceReferences(scope, flat);
        System.out.println(flat);
        JSONObject inputCondition = ((JSONObject) (parseList(scope, flat)).get(0));
        JSONObject condition = new JSONObject();

        condition.put("type", "Branch");
        JSONArray input = new JSONArray();
        input.add(inputCondition);
        condition.put("input", input);
        JSONArray output = new JSONArray();
        output.add(parseBlockBody(scope, structure.getIfTrue()));
        output.add(parseBlockBody(scope, structure.getIfFalse()));
        condition.put("output", output);
        return condition;
    }

    public static List flattenValueAssignment(ValueAssignmentStructure valueAssignmentStructure) {
        List list = new ArrayList();
        list.add(valueAssignmentStructure.getName());
        list.add(new Token(TokenType.NAME, "set"));
        list.addAll(flattenItemList(new ItemList(flatten(valueAssignmentStructure.getValue()))));
        System.out.println(list);
        return list;
    }

    public static List flattenBoolComparison(BooleanComparisonStructure comparisonStructure) {
        List output = new ArrayList();
        output.addAll(flatten((comparisonStructure.getLeft())));
        if(comparisonStructure.getComparisonOperator().getValue().equals("||")){
            output.add(new Token(TokenType.NAME, "or"));
        }
        else if(comparisonStructure.getComparisonOperator().getValue().equals("&&")){
            output.add(new Token(TokenType.NAME, "and"));
        }
        output.addAll(flattenItemList(new ItemList(flatten(comparisonStructure.getRight()))));
        return output;
    }
    public static List flattenBooleanOperator(BooleanEqualityStructure comparisonStructure) {
        List output = new ArrayList();
        output.addAll(flatten((comparisonStructure.getLeft())));
        if(comparisonStructure.getComparisonOperator().getValue().equals("==")){
            output.add(new Token(TokenType.NAME, "equal"));
        }
        else if(comparisonStructure.getComparisonOperator().getValue().equals(">")){
            output.add(new Token(TokenType.NAME, "gt"));
        }
        else if(comparisonStructure.getComparisonOperator().getValue().equals("<")){
            output.add(new Token(TokenType.NAME, "lt"));
        }
        output.addAll(flattenItemList(new ItemList(flatten(comparisonStructure.getRight()))));
        return output;
    }
    public static List flatten(Object o) {
        List list = new ArrayList();
        if (o instanceof TokenInvocationStructure tokenInvocationStructure) {
            list.addAll(flattenTokenInvocation(tokenInvocationStructure));
        } else if (o instanceof ActionInvocation actionInvocation) {
            list.addAll(flattenActionInvocation(actionInvocation));
        } else if (o instanceof ItemList itemList1) {
            list.addAll(flattenItemList(itemList1));
        }
        else if(o instanceof BooleanEqualityStructure equalityStructure) {
            list.addAll(flattenBooleanOperator(equalityStructure));
        }
        else if(o instanceof BooleanComparisonStructure comparisonStructure) {
            list.addAll(flattenBoolComparison(comparisonStructure));
        }
        else if(o instanceof ValueAssignmentStructure valueAssignmentStructure){
            list.addAll(flattenValueAssignment(valueAssignmentStructure));
        }
        else {
            list.add(o);
        }
        return list;
    }

    public static List flattenActionInvocation(ActionInvocation actionInvocation) {
        List list = new ArrayList();
        list.addAll(flatten(actionInvocation.getBase()));
        list.addAll(flatten(actionInvocation.getInvoking()));
        return list;
    }

    public static List flattenItemList(ItemList itemList) {
        List list = new ArrayList();
        for (Object o : itemList.getChildren()) {
            list.addAll(flatten(o));
        }
        return List.of(new ItemList(list));
    }

    public static List flattenTokenInvocation(TokenInvocationStructure tokenInvocationStructure) {
        List list = new ArrayList();
        list.add(tokenInvocationStructure.getPrefixToken());
        list.addAll(flattenItemList(tokenInvocationStructure.getItemList()));
        return list;
    }

    public static JSONObject parseActionInvocation(Scope scope, ActionInvocation actionInvocation) {
        List flat = flatten(actionInvocation);
//        System.out.println(flat);
        flat = replaceReferences(scope, flat);
        JSONObject condition = ((JSONObject) (parseList(scope, flat)).get(0));
//        return null;
        return condition;
    }

    public static List parseList(Scope scope, List data) {
        List list = new ArrayList();
        Object lastReference = null;
        DataType lastType = null;
        Token functionToken = null;
        System.out.println(data);
        Object lastObject = null;
        System.out.println("ALL DATA! " + data);
        for (Object o : data) {
            if (o instanceof ItemList itemList) {
                if(lastReference !=  null && functionToken != null) {
                    list.remove(lastReference);
                    list.remove(functionToken);
                    ItemList i = (new ItemList((List) parseList(scope, itemList.getChildren())));
                    InvocationCollection e = new InvocationCollection(lastReference, functionToken, i);
                    list.add(e);
                    lastObject = e;
                    lastReference = e;
                }
                else{
                    ItemList i = (new ItemList((List) parseList(scope, itemList.getChildren())));
                    list.addAll(i.getChildren());
                }

            } else if (o instanceof Token token) {
                System.out.println(lastObject);
                if (token.getType() == TokenType.NAME) {
                    if(lastObject != null && lastObject instanceof Token lastToken && lastToken.getType() == TokenType.TYPE) {
                        if(FunctionTypeLookup.typeHasConstant(DataType.getByName(lastToken.getValue() + "Type"), token.getValue())) {
                            list.remove(lastObject);
                            list.remove(lastReference);
                            ConstantValue e = new ConstantValue(lastToken, token);
                            list.add(e);
                            lastObject = e;
                            lastReference = e;
                            continue;
                        }
                        else if(FunctionTypeLookup.lookupStaticFunction(DataType.getByName(lastToken.getValue() + "Type"), token.getValue()) != null) {
                            lastReference = lastToken;
                            lastObject = token;
                            functionToken = token;
                        }
                        else{
                            try {
                                throw new Exception("Invalid constant/static value exception");
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    lastObject = token;
                    functionToken = token;
                } else {
                    System.out.println("Adding " + o);
                    list.add(o);
                    lastObject = token;
                }
            } else if (o instanceof TypeNameReference typeNameReference) {
                lastReference = typeNameReference;
                lastObject = typeNameReference;
                list.add(typeNameReference);
            } else {
                list.add(o);
                lastObject = o;
            }
            System.out.println(list);
        }
        System.out.println("LIST = " + list);
        List list2 = new ArrayList();
        for (Object o : list) {
            if (o instanceof InvocationCollection invocationCollection) {
                list2.add(collapseInvocation(scope, invocationCollection));
            }
            else if(o instanceof ConstantValue constantValue) {
                JSONObject jobj = new JSONObject();
                if(FunctionTypeLookup.typeHasConstant(DataType.getByName(constantValue.getType().getValue() + "Type"), constantValue.getValue().getValue())) {
                    jobj.put("type", constantValue.getType().getValue());
                    jobj.put("value", constantValue.getValue().getValue());
                    list2.add(jobj);
                }
                else{
                    System.out.println("ERROR!");
                }
            }
            else if(o instanceof Token token && token.getType() == TokenType.BOOLEAN_VALUE) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("type", "BooleanType");
                jsonObject.put("constant", token.getValue());
                list2.add(jsonObject);
            }
            else if(o instanceof Token token && token.getType() == TokenType.NUMBER_ASSIGNMENT) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("type", "NumberType");
                jsonObject.put("constant", token.getValue());
                list2.add(jsonObject);
            }
            else if(o instanceof HaloVariableReference<?,?,?> haloVariableReference) {
                list2.add(getVariableGetJSON(scope, haloVariableReference));
            }
            else if(o instanceof TypeNameReference typeNameReference) {
                list2.add(typeNameReference.toJSON());
            }
            else {
                list2.add(o);
            }
        }
        return list2;
    }

    public static JSONObject collapseInvocation(Scope scope, InvocationCollection collection) {
        JSONObject object = new JSONObject();
        Object base = collection.getActingOn();
        DataType baseType = null;
        if (base instanceof InvocationCollection invocationCollection) {
            base = collapseInvocation(scope, invocationCollection);
            baseType = DataType.nameToInstance(((JSONObject) base).get("returnType").toString());
        }
        if (base instanceof TypeNameReference typeNameReference) {
            baseType = typeNameReference.getTypeInstance();
            base = typeNameReference.toJSON();
        }
        if(base instanceof ConstantValue constantValue) {
            baseType = DataType.nameToInstance(constantValue.getType().getValue() + "Type");
            base = constantValue.toJSON();
        }
        if(base instanceof HaloVariableReference<?,?,?> haloVariableReference) {
            System.out.println("HALO!");
        }
//        if(base instanceof HaloVariableReference<?,?,?> haloVariableReference) {
//            BuiltInFunction builtInFunction = new BuiltInFunction()
//        }

        BuiltInFunction funct;
        if(base instanceof Token token && token.getType() == TokenType.TYPE) {
            baseType = DataType.nameToInstance(token.getValue() + "Type");
            funct = FunctionTypeLookup.lookupStaticFunction(baseType.getClass(), (collection.getAction()).getValue());
        }
        else{
            funct = FunctionTypeLookup.lookupFunction(baseType.getClass(), (collection.getAction()).getValue());
        }

        if (funct == null) {
            System.out.println("FUNCTION NOT FOUND!" + collection.getAction().getValue());
            return null;
        }


        JSONArray jsonArray = new JSONArray();
        for (Object o : collection.getParameters().getChildren()) {
            jsonArray.add(o);
        }
        if(funct.getChildParameterPosition() != -1) {
            jsonArray.add(funct.getChildParameterPosition(), base);
        }

        JSONArray outputArray = new JSONArray();
        Node node = funct.instantiateNode();
        for (DataType o : node.getOutputs()) {
//            Class<? extends DataType> type = (Class<? extends DataType>) o;
            JSONObject output = new JSONObject();
            output.put("type", o.getClass().getSimpleName());
            output.put("_ref", UUID.randomUUID().toString());
            output.put("name", o.getName());
            outputArray.add(output);
        }

        if (funct.getOutput() != null) {
            object.put("returnType", funct.getOutput().getSimpleName());
            if (funct.getOutputIndex() != -1) {
                System.out.println(funct);
                object.put("value", ((JSONObject) outputArray.get(funct.getOutputIndex())).get("_ref"));
                object.put("outputValueName", ((JSONObject) outputArray.get(funct.getOutputIndex())).get("name"));
            }
        } else {
            object.put("next", null);
        }

        object.put("input", jsonArray);
        object.put("output", outputArray);
        object.put("type", funct.getType().getSimpleName());
        return object;
    }

    public static JSONObject buildObject(BuiltInFunction builtInFunction) {
        JSONObject object = new JSONObject();
        object.put("type", builtInFunction.getType().getSimpleName());
        object.put("input", new JSONArray());
        object.put("output", new JSONArray());
        object.put("returnType", builtInFunction.getOutput().getSimpleName());
        return object;
    }



    public static List replaceReferences(Scope scope, List list) {
        List newList = new ArrayList();
        for (int i = 0; i<list.size(); i++) {
            Object o = list.get(i);
            if (o instanceof Token token && token.getType() == TokenType.NAME) {
                if (scope.get(token.getValue()) != null) {
                    newList.add(scope.get(token.getValue()));
                    continue;
                }
                else if(scope.getHalo(token.getValue()) != null) {
                    newList.add(scope.getHalo(token.getValue()));
                    continue;
                }
            } else if (o instanceof ItemList itemList) {
                ItemList itemList1 = new ItemList(replaceReferences(scope, itemList.getChildren()));
                newList.add(itemList1);
                continue;
            }
            newList.add(o);
        }
        return newList;
    }

    public static JSONObject parseStructures(List list) {
        JSONArray values = new JSONArray();
        for (Object object : list) {
            if (object instanceof List<?> list1) {
                values.add(parseStructures(list1));
            }
            if(object instanceof VariableDeclarationStructure variableDeclarationStructure) {
                //todo 1
            }
            if(object instanceof TypedVariableDeclarationStructure typedVariableDeclarationStructure){
                //todo 2
                values.add(parseTypedVariableDeclaration(globalScope, typedVariableDeclarationStructure));
            }
            if (object instanceof EventDeclarationStructure eventDeclarationStructure) {
                values.add(parseEventDeclarationStructure(globalScope, eventDeclarationStructure));
            }
        }
        JSONObject obj = new JSONObject();
        obj.put("nodes", values);
        System.out.println(obj.toJSONString());
        return obj;
    }

    public static JSONObject getIdentifierObject(Token identifier) {
        JSONObject object = new JSONObject();
        object.put("type", "IdentifierType");
        object.put("value", identifier.getValue());
        return object;
    }
    private static JSONObject parseTypedVariableDeclaration(Scope globalScope, TypedVariableDeclarationStructure typedVariableDeclarationStructure) {
        Class<? extends IISNode> nodeType = AllNodes.getVariableDeclarationForType(DataType.nameToInstance(typedVariableDeclarationStructure.getValue().getValue() + "Type"));
        try {
            IISNode iisNode = (IISNode) nodeType.getConstructors()[0].newInstance();

            JSONObject object = new JSONObject();
            object.put("type", iisNode.getClass().getSimpleName());

            JSONArray inputArray = new JSONArray();
            inputArray.add(getIdentifierObject(typedVariableDeclarationStructure.getName()));
            inputArray.add(null);
            JSONObject scopeConstant = new JSONObject();
            scopeConstant.put("type", "ScopeType");
            scopeConstant.put("constant", typedVariableDeclarationStructure.getDeclarationScope().getValue());
            inputArray.add(scopeConstant);
            object.put("input", inputArray);
            globalScope.haloDeclare(typedVariableDeclarationStructure.getDeclarationScope(), typedVariableDeclarationStructure.getName(), DataType.nameToInstance(typedVariableDeclarationStructure.getValue().getValue() + "Type"));

            return object;




        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static JSONObject parseVariableAssignmentOperator(Scope scope, ValueAssignmentStructure valueAssignmentStructure) {
        System.out.println(valueAssignmentStructure.getValue() + " = VCAL@");
        List flat = flatten(valueAssignmentStructure.getValue());
        System.out.println(flat + " AFTER FLATTEN");
        flat = replaceReferences(scope, flat);
        System.out.println("AFTER REF" + flat);
        flat = parseList(scope, flat);
        System.out.println(flat + " == FLAT");
        HaloVariableReference haloVariableReference = scope.getHalo(valueAssignmentStructure.getName().getValue());
        if(haloVariableReference == null) return null;
        Class<? extends IVSONode> className = AllNodes.getVariableSetterForType(haloVariableReference.getType());
        JSONObject object = new JSONObject();
        object.put("type", className.getSimpleName());
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(getIdentifierObject(valueAssignmentStructure.getName()));
        System.out.println(valueAssignmentStructure.getValue() + " =  VAL");
        jsonArray.add(flat.get(0));
        JSONObject scopeId = new JSONObject();
        scopeId.put("type", "ScopeType");
        scopeId.put("constant", haloVariableReference.getScope());
        jsonArray.add(scopeId);
        jsonArray.add(null);
//        jsona
        object.put("input", jsonArray);
        return object;
    }
    public static JSONObject getVariableGetJSON(Scope scope, HaloVariableReference haloVariableReference) {
//        HaloVariableReference haloVariableReference = scope.getHalo(name.getValue());
        if(haloVariableReference == null) return null;
        Class<? extends ISONode> className = AllNodes.getVariableGetterForType(haloVariableReference.getType());
        JSONObject object = new JSONObject();
        object.put("type", className.getSimpleName());
        JSONArray jsonArray = new JSONArray();
        Token identifier = new Token(TokenType.NAME, haloVariableReference.getName());
        jsonArray.add(getIdentifierObject(identifier));
//        jsonArray.add(parseList(scope, flatten(valueAssignmentStructure.getValue())));
        JSONObject scopeId = new JSONObject();
        scopeId.put("type", "ScopeType");
        scopeId.put("constant", haloVariableReference.getScope());
        jsonArray.add(scopeId);
        jsonArray.add(null);
//        jsona
        object.put("input", jsonArray);

        JSONArray outputArray = new JSONArray();
        UUID outputValue = UUID.randomUUID();
        JSONObject refItem = new JSONObject();
        refItem.put("type", haloVariableReference.getType().getClass().getSimpleName());
        refItem.put("_ref", outputValue.toString());
        refItem.put("name", identifier.getValue());
        outputArray.add(refItem);

        object.put("output", outputArray);
        object.put("value", outputValue.toString());
        return object;
    }
}
