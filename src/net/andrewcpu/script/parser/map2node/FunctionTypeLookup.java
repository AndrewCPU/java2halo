package net.andrewcpu.script.parser.map2node;

import net.andrewcpu.halo.nodes.AllNodes;
import net.andrewcpu.halo.nodes.Node;
import net.andrewcpu.halo.type.*;
import net.andrewcpu.script.parser.typemap.util.DataTypeToElement;
import net.andrewcpu.script.tokenizer.Token;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionTypeLookup {
    public static JSONObject lookupType(Class<? extends DataType> type) {
        File file = null;
        if (type == PlayerType.class) {
            file = new File("C:\\Users\\stein\\Documents\\GitHub\\java2halo\\langdef\\Player.json");
        } else if (type == TeamType.class) {
            file = new File("C:\\Users\\stein\\Documents\\GitHub\\java2halo\\langdef\\Team.json");
        } else if (type == BooleanType.class) {
            file = new File("C:\\Users\\stein\\Documents\\GitHub\\java2halo\\langdef\\Boolean.json");
        }
        else if(type == WeaponType.class) {
            file = new File("C:\\Users\\stein\\Documents\\GitHub\\java2halo\\langdef\\Weapon.json");
        }
        else if(type == WeaponTypeType.class) {
            file = new File("C:\\Users\\stein\\Documents\\GitHub\\java2halo\\langdef\\WeaponType.json");
        }
        else if(type == WeaponAdditionMethodType.class) {
            file = new File("C:\\Users\\stein\\Documents\\GitHub\\java2halo\\langdef\\WeaponAdditionMethod.json");
        }
        else if(type == VehicleType.class) {
            file = new File("C:\\Users\\stein\\Documents\\GitHub\\java2halo\\langdef\\Vehicle.json");
        }
        else if(type == VehicleTypeType.class) {
            file = new File("C:\\Users\\stein\\Documents\\GitHub\\java2halo\\langdef\\VehicleType.json");
        }
        else if(type == VectorType.class) {
            file = new File("C:\\Users\\stein\\Documents\\GitHub\\java2halo\\langdef\\Vector.json");
        }
        else if(type == NumberType.class) {
            file = new File("C:\\Users\\stein\\Documents\\GitHub\\java2halo\\langdef\\Number.json");
        }
        else if(type == MovementCurveType.class) {
            file = new File("C:\\Users\\stein\\Documents\\GitHub\\java2halo\\langdef\\MovementCurve.json");
        }
        else if(type == UIMessageTemplateType.class) {
            file = new File("C:\\Users\\stein\\Documents\\GitHub\\java2halo\\langdef\\MessageTemplate.json");
        }
        else if(type == GrenadeTypeType.class) {
            file = new File("C:\\Users\\stein\\Documents\\GitHub\\java2halo\\langdef\\GrenadeType.json");
        }
        else if(type == EquipmentType.class) {
            file = new File("C:\\Users\\stein\\Documents\\GitHub\\java2halo\\langdef\\Equipment.json");
        }
        else if(type == EquipmentTypeType.class) {
            file = new File("C:\\Users\\stein\\Documents\\GitHub\\java2halo\\langdef\\EquipmentType.json");
        }
        else if(type == GameType.class) {
            file = new File("C:\\Users\\stein\\Documents\\GitHub\\java2halo\\langdef\\Game.json");
        }
        else if(type == ScopeType.class) {
            file = new File("C:\\Users\\stein\\Documents\\GitHub\\java2halo\\langdef\\Scope.json");
        }
        else if(type == DeathContextType.class) {
            file = new File("C:\\Users\\stein\\Documents\\GitHub\\java2halo\\langdef\\DeathContext.json");
        }
        if (file == null) {
            return null;
        }
        JSONObject object;
        try {
            return (JSONObject) new JSONParser().parse(Files.readString(file.toPath()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    public static BuiltInFunction lookupComparison(Class<? extends DataType> type, Token comparison) {
        if (type == NumberType.class) {

        } else {
            return lookupFunction(type, "equal");
        }
        return null;
    }

    public static BuiltInFunction lookupAnd(Class<? extends DataType> type) {
        if (type == BooleanType.class) {
            return lookupFunction(type, "and");
        } else {
        }
        return null;
    }

    public static BuiltInFunction lookupOr(Class<? extends DataType> type) {
        if (type == BooleanType.class) {
            return lookupFunction(type, "or");
        } else {
        }
        return null;
    }

    public static boolean typeHasConstant(Class<? extends DataType> type, String constant) {
        JSONObject typeData = lookupType(type);
        if(typeData.containsKey("constants")){
            if(((JSONArray)typeData.get("constants")).contains(constant)){
                return true;
            }
        }
        return false;
    }

    public static BuiltInFunction lookupFunction(Class<? extends DataType> dataType, String function) {
        JSONObject object = lookupType(dataType);
        if (object == null) {
            System.out.println("Failed to find function file for " + dataType);
            return null;
        }
        if (!object.containsKey(function)) {
            System.out.println("Function lookup for " + dataType + " failed, could not find " + function);
            return null;
        }
        JSONObject object1 = (JSONObject) object.get(function);
        Class<? extends DataType> type = DataType.getByName(object1.get("returnType").toString());
        JSONObject object2 = (JSONObject) object1.get("mapping");
        String value = object2.getOrDefault("value", "____$").toString();
        List<Class<? extends DataType>> outputs = (List<Class<? extends DataType>>) ((JSONArray) object2.get("output")).stream().map(entry -> DataType.getByName(((JSONObject) entry).get("type").toString())).collect(Collectors.toList());
        outputs.forEach(o -> System.out.println(o.getSimpleName()));
        int outputIndex = -1;

        int n = 0;
        for(Object o : (JSONArray)object2.get("output")){
            if(((JSONObject)o).get("_ref").equals(value)){
                outputIndex = n;
            }
            n++;
        }

        Class<? extends Node> usefulNodeType = null;
        for (Class nodeType : AllNodes.getAllNodes()) {
            if (nodeType.getSimpleName().equals(object2.get("type").toString())) {
                usefulNodeType = nodeType;
                break;
            }
        }

        int i = 0;
        int fillIn = -1;
        DataType[] inputs = new DataType[((JSONArray) object2.get("input")).size()];
        String fillInType = null;
        for (Object o : (JSONArray) object2.get("input")) {
            if (o instanceof JSONObject jsonObject) {
                if (jsonObject.get("_ref").equals("$0")) {
                    fillIn = i;
                    fillInType = jsonObject.get("type").toString();
                }
                try {
                    inputs[i] = (DataType) ((DataType.getByName(jsonObject.get("type").toString())).getConstructors()[0].newInstance("input" + i));
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
            i++;
        }


        BuiltInFunction builtInFunction = new BuiltInFunction(function, usefulNodeType, DataType.getByName(fillInType), inputs, type, outputs, fillIn, outputIndex);
        return builtInFunction;
    }

    public static BuiltInFunction lookupStaticFunction(Class<? extends DataType> dataType, String function) {
        JSONObject object = lookupType(dataType);

        if (object == null) {
            System.out.println("Failed to find function file for " + dataType);
            return null;
        }
        if(!object.containsKey("statics")){
            System.out.println("Type has no static definitions.");
            return null;
        }
        object = (JSONObject) object.get("statics");

        if (!object.containsKey(function)) {
            System.out.println("Function lookup for " + dataType + " failed, could not find " + function);
            return null;
        }

        JSONObject object1 = (JSONObject) object.get(function);
        Class<? extends DataType> type = DataType.getByName(object1.get("returnType").toString());
        JSONObject object2 = (JSONObject) object1.get("mapping");
        String value = object2.getOrDefault("value", "____$").toString();
        List<Class<? extends DataType>> outputs = (List<Class<? extends DataType>>) ((JSONArray) object2.get("output")).stream().map(entry -> DataType.getByName(((JSONObject) entry).get("type").toString())).collect(Collectors.toList());
        outputs.forEach(o -> System.out.println(o.getSimpleName()));
        int outputIndex = -1;

        int n = 0;
        for(Object o : (JSONArray)object2.get("output")){
            if(((JSONObject)o).get("_ref").equals(value)){
                outputIndex = n;
            }
            n++;
        }

        Class<? extends Node> usefulNodeType = null;
        for (Class nodeType : AllNodes.getAllNodes()) {
            if (nodeType.getSimpleName().equals(object2.get("type").toString())) {
                usefulNodeType = nodeType;
                break;
            }
        }

        int i = 0;
//        int fillIn = -1;
        DataType[] inputs = new DataType[((JSONArray) object2.get("input")).size()];
//        String fillInType = null;
        for (Object o : (JSONArray) object2.get("input")) {
            if (o instanceof JSONObject jsonObject) {
                try {
                    inputs[i] = (DataType) ((DataType.getByName(jsonObject.get("type").toString())).getConstructors()[0].newInstance("input" + i));
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
            i++;
        }


        BuiltInFunction builtInFunction = new BuiltInFunction(function, usefulNodeType, null, inputs, type, outputs, -1, outputIndex);
        return builtInFunction;
    }
}
