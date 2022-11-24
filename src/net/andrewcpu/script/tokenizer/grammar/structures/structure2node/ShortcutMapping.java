package net.andrewcpu.script.tokenizer.grammar.structures.structure2node;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ShortcutMapping {
    public static void main(String[] args) throws Exception{
        File file = new File("langdef/Player.json");
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(Files.readString(file.toPath()));
        System.out.println(jsonObject.toJSONString());

        UUID playerReference = UUID.randomUUID();
        String function = "setTeam";
        JSONObject shortcut = (JSONObject) jsonObject.get(function);
        String returnType = shortcut.get("returnType").toString();
        JSONObject mapping = (JSONObject) shortcut.get("mapping");

        System.out.println("player." + function + "():");
        System.out.println("Expected Function Return Type: " + returnType);
        System.out.println("Expected inputs: " + ((List)shortcut.get("input")).size());
        System.out.println("Proper Node Map: ");
        System.out.println(mapping.get("type").toString() + " = NODE TYPE");

        int index = 0;
        for(Object object : (JSONArray)mapping.get("input")) {
            JSONObject inputObject = (JSONObject) object;
            if(inputObject.get("_ref").equals("$0")){
                System.out.println("PLAYER will be inserted into " + index);
                break;
            }
            index++;
        }
        System.out.println("Resulting Function Return Type: " + ((JSONObject)(((JSONArray)mapping.get("output")).stream().filter(obj -> (((JSONObject)obj)).get("_ref").equals(mapping.get("value")))).findFirst().get()).get("type"));
    }
}
