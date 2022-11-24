package net.andrewcpu.script.parser.map2node;

import net.andrewcpu.halo.nodes.AllNodes;
import net.andrewcpu.halo.nodes.Node;
import net.andrewcpu.halo.type.*;
import net.andrewcpu.script.tokenizer.Token;
import net.andrewcpu.script.tokenizer.TokenType;
import net.andrewcpu.script.tokenizer.grammar.Stack;
import net.andrewcpu.script.tokenizer.grammar.structures.*;
import net.andrewcpu.script.tokenizer.grammar.structures.structure2node.TypeNameReference;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class StructuresToNodes {

    public static DataType[] eventDeclarationOutputs(String mName) {
        String name = mName.substring(1);
        List<Class> all = AllNodes.getEventDeclarations();
        for (Class entry : all) {
            if (entry.getSimpleName().equalsIgnoreCase(name)) {
                try {
                    Node node = (Node) (entry.getConstructors()[0].newInstance());
                    return node.getOutputs();
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }

    public static JSONObject parseEventStructure(EventDeclarationStructure eventDeclarationStructure) {
        DataType[] outputs = eventDeclarationOutputs(eventDeclarationStructure.getEventDeclaration().getValue());
        if (outputs == null) {
            System.out.println("ERROR!");
            return null;
        }
        Object[][] splitResult = eventDeclarationStructure.getParameters().split(TokenType.LIST_SEPARATOR);
        int n = 0;
        List<TypeNameReference> refs = new ArrayList<>();
        ItemList itemList = new ItemList(new ArrayList());
        for (Object[] objects : splitResult) {
            Token token = (Token) objects[0];
            TypeNameReference typeNameReference = new TypeNameReference(outputs[n].getClass(), token.getValue());
            n++;
            refs.add(typeNameReference);
            itemList.getChildren().add(typeNameReference);
        }
        eventDeclarationStructure.setParameters(itemList);
        refs.forEach(System.out::println);
        JSONArray outputReferences = new JSONArray();
        for (TypeNameReference ref : refs) {
            JSONObject object = new JSONObject();
            object.put("type", ref.getType().getSimpleName());
            object.put("_ref", ref.getReference().toString());
            object.put("name", ref.getReferenceName());
            outputReferences.add(object);
        }
        JSONObject object = new JSONObject();
        object.put("output", outputReferences);
        object.put("type", eventDeclarationStructure.getEventDeclaration().getValue().substring(1));
        object.put("next", parseBody(refs, eventDeclarationStructure.getBody()));
        return object;
//		System.out.println(Arrays.stream(outputs).map(type -> type.getClass().getSimpleName()).collect(Collectors.joining(", ")));
    }

    public static List flattenActionInvocation(ActionInvocation actionInvocation) {
        List returnable = new ArrayList();
        if (actionInvocation.getBase() instanceof Token token) {
            returnable.add(token);
        } else if (actionInvocation.getBase() instanceof TokenInvocationStructure tokenInvocationStructure) {
            returnable.addAll(flattenTokenInvocation(tokenInvocationStructure));
        } else if (actionInvocation.getBase() instanceof ActionInvocation actionInvocation1) {
            returnable.addAll(flattenActionInvocation(actionInvocation1));
        }

        if (actionInvocation.getInvoking() instanceof Token token) {
            returnable.add(token);
        } else if (actionInvocation.getInvoking() instanceof TokenInvocationStructure tokenInvocationStructure) {
            returnable.addAll(flattenTokenInvocation(tokenInvocationStructure));
        } else if (actionInvocation.getInvoking() instanceof ActionInvocation actionInvocation1) {
            returnable.addAll(flattenActionInvocation(actionInvocation1));
        }

        return returnable;
    }

    public static List flattenItemList(ItemList itemList) {
        List flat = new ArrayList();
        for (Object o : itemList.getChildren()) {
            flat.addAll(flatten(o));
        }
        return flat;
    }

    public static List flatten(Object o) {
        if (o instanceof TokenInvocationStructure tokenInvocationStructure) {
            return flattenTokenInvocation(tokenInvocationStructure);
        }
        if (o instanceof ItemList itemList) {
            return flattenItemList(itemList);
        }
        if (o instanceof ActionInvocation actionInvocation) {
            return flattenActionInvocation(actionInvocation);
        }
        if (o instanceof Token) {
            return List.of(o);
        }
        return null;
    }

    public static List flattenTokenInvocation(TokenInvocationStructure tokenInvocationStructure) {
        List returnable = new ArrayList();
        if (tokenInvocationStructure.getPrefixToken() instanceof Token token) {
            returnable.add(token);
        } else if (tokenInvocationStructure.getPrefixToken() instanceof TokenInvocationStructure tokenInvocationStructure1) {
            returnable.addAll(flattenTokenInvocation(tokenInvocationStructure));
        } else if (tokenInvocationStructure.getPrefixToken() instanceof ActionInvocation actionInvocation1) {
            returnable.addAll(flattenActionInvocation(actionInvocation1));
        }
        ItemList itemList = new ItemList(new ArrayList());
        itemList.setChildren(flattenItemList(tokenInvocationStructure.getItemList()));
        returnable.add(itemList);
        return returnable;
    }

    public static TypeNameReference hasReference(List<TypeNameReference> references, String name) {
        for (TypeNameReference typeNameReference : references) {
            if (typeNameReference.getReferenceName().equals(name)) {
                return typeNameReference;
            }
        }
        return null;
    }

    public static JSONObject parseActionInvocationCollapsed(List<TypeNameReference> references, ActionInvocation actionInvocation) {
        return parseList(references, flattenActionInvocation(actionInvocation));
    }

    public static JSONObject buildJSONObject(TypeNameReference exec, BuiltInFunction function, List list) {
        JSONNode jsonNode = new JSONNode(function.getType(), function.getOutput());
        int n = 0;
        for (int i = 0; i < function.getInputs().length; i++) {
            if (i == function.getChildParameterPosition() && exec != null) {

            } else {
                jsonNode.getInputs()[i] = (JSONObject) list.get(n);
                n++;
            }
        }

        for (int i = 0; i < function.getOutputs().size(); i++) {
            jsonNode.getOutputs()[i].put("type", ((Class) function.getOutputs().get(i)).getSimpleName());
        }
        JSONObject obj = new JSONObject();
        obj.put("value", exec.getReference().toString());
        obj.put("type", exec.getType().getSimpleName());
        jsonNode.getInputs()[function.getChildParameterPosition()] = obj;
        return jsonNode;

    }

    public static JSONObject buildJSONObject(JSONObject input, BuiltInFunction function, List list) {
        JSONNode jsonNode = new JSONNode(function.getType(), function.getOutput());
        int n = 0;
        for (int i = 0; i < function.getInputs().length; i++) {
            if (i == function.getChildParameterPosition() && input != null) {

            } else {
                jsonNode.getInputs()[i] = (JSONObject) list.get(n);
                n++;
            }
        }

        for (int i = 0; i < function.getOutputs().size(); i++) {
            jsonNode.getOutputs()[i].put("type", ((Class) function.getOutputs().get(i)).getSimpleName());
        }
        jsonNode.getInputs()[function.getChildParameterPosition()] = input;
        return jsonNode;

    }

    public static JSONObject parseList(List<TypeNameReference> references, List flattened) {
        System.out.println(flattened);
        Class<? extends DataType> lastType = null;

        BuiltInFunction lastFunction = null;
        TypeNameReference executingOn = null;

        JSONObject firstExecuted = null;
        JSONObject lastExecuted = null;


        for (Object o : flattened) {
            if (o instanceof ItemList itemList) {
                Object[][] list = itemList.split(TokenType.LIST_SEPARATOR);
                List<JSONObject> value = new ArrayList<>();
                for (Object[] l : list) {
                    value.add(parseList(references, List.of(l)));
                }
                if (value.size() != lastFunction.getInputs().length - 1) {
                    try {
                        throw new Exception("Error: Invalid parameter amount for " + lastFunction.getName());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    JSONObject object = (buildJSONObject(executingOn, lastFunction, value));
                    if (firstExecuted == null) {
                        firstExecuted = object;
                    }
                    if (lastExecuted == null) {
                        lastExecuted = object;
                    } else {
                        lastExecuted.put("next", object);
                        lastExecuted = object;
                    }
                    System.out.println("Function " + lastFunction.getName() + " has proper parameters.");
                    executingOn = new TypeNameReference(lastFunction.getOutput() != null ? lastType : ExecutionThreadType.class, UUID.randomUUID().toString());

                }
            }
            if (o instanceof Token token) {
                if (token.getType() == TokenType.NAME) {
                    TypeNameReference typeNameReference = hasReference(references, token.getValue());
                    if (typeNameReference == null && lastType == null) {
                        try {
                            throw new Exception("Error: Undefined reference " + token.getValue());
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    } else if (typeNameReference == null) {
                        BuiltInFunction function = FunctionTypeLookup.lookupFunction(lastType, token.getValue());
                        if (function == null) {
                            try {
                                throw new Exception("Error: Undefined function " + token.getValue() + " for type " + lastType.getSimpleName());
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                        lastFunction = function;
                        System.out.println("Found " + function);
                        lastType = function.getOutput();
                    } else {
                        executingOn = typeNameReference;
                        lastType = typeNameReference.getType();
                    }
                } else if (token.getType() == TokenType.BOOLEAN_OPERATOR) {
                    System.out.println("BOOLEAN OPERATOR ON " + lastType);
                }
            }
        }
        return firstExecuted;
    }

    public static JSONObject parseIfConditions(List<TypeNameReference> references, ItemList ifConditions) {
        JSONObject object = new JSONObject();
        Object[][] list = ifConditions.split(TokenType.BOOLEAN_OPERATOR);
        List<JSONObject> value = new ArrayList<>();
        for (Object[] l : list) {
            value.add(parseList(references, flatten(l[0])));
        }
        List objAndOperatorList = new ArrayList();
        List<Token> boolOps = new ArrayList<>();
        for (Object o : ifConditions.getChildren()) {
            if (o instanceof Token token) {
                if (token.getType() == TokenType.BOOLEAN_OPERATOR) {
                    boolOps.add(token);
                }
            }
        }
        int boolOpIndex = 0;
        for (JSONObject val : value) {
            objAndOperatorList.add(val);
            if (boolOpIndex < boolOps.size()) {
                objAndOperatorList.add(boolOps.get(boolOpIndex));
                boolOpIndex++;
            }
        }

        List comparisonJson = new ArrayList();
        DataType lastType = null;
        Token operator = null;
        JSONObject lastJSONObject = null;
        TypeNameReference executingOn = null;
        for (Object obj : objAndOperatorList) {
            if (obj instanceof Token token) {
                if (!(lastType instanceof NumberType) && (token.getValue().equals(">") || token.getValue().equals("<"))) {
                    System.out.println("Cannot compare non numbers (" + lastType.getClass().getSimpleName() + ") with " + token.getValue());
                    return null;
                }
                if (token.getValue().equals(">")) {
                    operator = token;
                } else if (token.getValue().equals("<")) {
                    operator = token;
                } else if (token.getValue().equals("==")) {
                    operator = token;
                }
            }
            if (obj instanceof JSONObject jsonObject) {
                Class<? extends DataType> objReturnType = DataType.getByName(jsonObject.get("type").toString());
                try {
                    DataType type = (DataType) (objReturnType.getConstructors()[0].newInstance("type"));
                    if (type instanceof ComparableType) {
                        if (lastType != null && operator != null) {
                            BuiltInFunction compare = FunctionTypeLookup.lookupComparison(lastType.getClass(), operator);
                            JSONObject comparison = buildJSONObject(lastJSONObject, compare, List.of(obj));
                            return comparison;
                        }
                        lastType = type;
                        executingOn = new TypeNameReference(lastType.getClass(), UUID.randomUUID().toString());
                        lastJSONObject = jsonObject;
                    } else {
                        System.out.println("Wtf. This is not comparable.");
                    }
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        System.out.println(objAndOperatorList);
        System.out.println("VAL=" + value);

        return object;
    }

    public static JSONObject parseIfConditions(List<TypeNameReference> references, IfElseStructure ifElseStructure) {
//        List flattenedIfElse = flatten(ifElseStructure.getIfConditions());
        //needs to be broken down into <, >, == and &&, ||
        List<List> groups = new ArrayList<>();

        List current = new ArrayList();
        List<Token> operators = new ArrayList();
        for (Object o : ifElseStructure.getIfConditions().getChildren()) {
            if (o instanceof Token token) {
                if (token.getType() == TokenType.BOOLEAN_OPERATOR) {
                    if (token.getValue().equals("||") || token.getValue().equals("&&")) {
                        groups.add(current);
                        operators.add(token);
                        continue;
                    }
                }
            }
            current.add(o);
        }
        groups.add(current);
        List<JSONObject> boolOutput = new ArrayList<>();
        for (List group : groups) {
            boolOutput.add(parseIfConditions(references, new ItemList(group)));
        }


//        JSONObject first = null;
//        JSONObject last = null;
        JSONObject first = null;
        JSONObject last = null;
//        int comparator = 0;
        JSONObject toBeCompared = boolOutput.get(0);
        int comparingWithIndex = 1;
        for(int comparator = 0; comparator<operators.size(); comparator++){
            Token token = operators.get(comparator);
            JSONObject comparingWith = boolOutput.get(comparingWithIndex++);
            BuiltInFunction compareFunction = null;
            if(token.getValue().equals("||")){
                compareFunction = FunctionTypeLookup.lookupOr(BooleanType.class);
            }
            else if(token.getValue().equals("&&")){
                compareFunction = FunctionTypeLookup.lookupAnd(BooleanType.class);
            }
            toBeCompared = buildJSONObject(toBeCompared, compareFunction, List.of(comparingWith));
        }

        System.out.println(boolOutput);

        System.out.println(groups);
        return toBeCompared;
    }

    public static JSONObject parseIfElseStructure(List<TypeNameReference> references, IfElseStructure ifElseStructure) {
        System.out.println(ifElseStructure.getIfConditions());
        //todo, think about if(a == b == c == d)
        JSONObject jsonObject = parseIfConditions(references, ifElseStructure);
        //todo, we will need to populate a Branch function with the jsonObject as the "conditioins" and then parse the if block and else block
        System.out.println(jsonObject.toJSONString());
        return jsonObject;
    }

    public static JSONObject parseBody(List<TypeNameReference> references, BlockStructure blockStructure) {
        JSONObject last = null;
        JSONObject first = null;
        for (Object o : blockStructure.getChildren()) {
            JSONObject parsed = null;
            if (o instanceof ActionInvocation actionInvocation) {
                parsed = (parseActionInvocationCollapsed(references, actionInvocation));
            } else if (o instanceof IfElseStructure ifElseStructure) {
                parsed = parseIfElseStructure(references, ifElseStructure);
            }
            if (parsed != null) {
                if (first == null) {
                    first = parsed;
                }
                if (last == null) {
                    last = parsed;
                } else {
                    last.put("next", parsed);
                    last = parsed;
                }
            }
        }

        return first;
    }

    public static void structuresToNodes(List list) {
        // we need to invert almost ALL function calls here.
        StructParse.parseStructures(list);
        if(false == false) {
            return;
        }
        for (Object o : list) {
            if (o instanceof List<?> oList) {
                structuresToNodes(oList);
                Stack stack = new Stack();
                stack.push((List<Object>) oList);
                stack.print();
            } else if (o instanceof EventDeclarationStructure eventDeclarationStructure) {
                JSONObject obj = parseEventStructure(eventDeclarationStructure);
                System.out.println(obj.toJSONString());
            }
        }
        /**
         *  onPlayerKilled(killed, killing, deathContext):
         *  (
         *      branch(
         *          (compareTeams(
         *              getPlayerTeam(killed),
         *              getPlayerTeam(killer)
         *          )),
         *          (ifTrue print(killed))
         *          (ifFalse (
         *              blockPlayerRespawns(killed)
         *              setPlayerTeam(killed, getPlayerTeam(killer))
         *          ))
         *      )
         *  )
         *
         *
         */
    }
}
