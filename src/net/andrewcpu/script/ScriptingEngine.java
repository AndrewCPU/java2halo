package net.andrewcpu.script;

import net.andrewcpu.halo.nodemesh.*;
import net.andrewcpu.halo.nodes.AllNodes;
import net.andrewcpu.halo.nodes.Node;
import net.andrewcpu.halo.type.DataType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class ScriptingEngine {
	public static void main(String[] args) throws Exception{

		JSONObject output = new JSONObject();
//		output.put("nodes", 		AllNodes.getAllNodes().stream().map(clazz -> {
//			try {
//				System.out.println(clazz);
//				Node node = (Node) (clazz.getConstructors()[0].newInstance());
//				return node.toJSON();
////				System.out.println(node.toJSON().toJSONString());
//			} catch (InstantiationException e) {
//				throw new RuntimeException(e);
//			} catch (IllegalAccessException e) {
//				throw new RuntimeException(e);
//			} catch (InvocationTargetException e) {
//				throw new RuntimeException(e);
//			}
//		}).collect(Collectors.toList()));
		GameMaster playerMaster = new GameMaster();

//		JSONObject player = new JSONObject();
//		player.put("type", "Player");
//		player.put("_ref", "$0");
		JSONObject mapping = new JSONObject();
		for(PrefillNodeValue node : playerMaster.getters()) {
			mapping.put(node.getName(), generateMappingForNode(node));
		}
		for(PrefillNodeValue node : playerMaster.setters()) {
			mapping.put(node.getName(), generateMappingForNode(node));
		}
		for(PrefillNodeValue node : playerMaster.functions()) {
			mapping.put(node.getName(), generateMappingForNode(node));
		}

		System.out.println(mapping.toJSONString());
	}

	public static JSONObject generateMappingForNode(PrefillNodeValue node) {
		JSONObject shortcut = new JSONObject();
		shortcut.put("returnType", node.getNode().getOutputs().length == 0 ? "void" : node.getNode().getOutputs()[0].getClass().getSimpleName());
		JSONObject newMapping = new JSONObject();
		newMapping.put("type", node.getNode().getClass().getSimpleName());
		JSONArray jsonArray = new JSONArray();

		DataType[] types = node.getInputNodes();
		int index = 1;
		for(DataType type : types) {
			JSONObject obj = new JSONObject();
			obj.put("type", type.getClass().getSimpleName());
			obj.put("_ref", "$" + (index++));
			jsonArray.add(obj);
		}

		JSONArray newInputs = new JSONArray();
		JSONArray newOutputs = new JSONArray();
		int n = 1;
		for(DataType type : node.getInputNodes()) {
			JSONObject newInput = new JSONObject();
			newInput.put("type", type.getClass().getSimpleName());
			newInput.put("_ref", "$" + (n++));
			newInputs.add(newInput);
		}
		if(node.getFillIndex() != -1){
			JSONObject obj = new JSONObject();
			obj.put("_ref", "$0");
			obj.put("type", node.getNode().getInputs()[node.getFillIndex()].getClass().getSimpleName());
			newInputs.add(node.getFillIndex(), obj);
		}


		for(DataType type : node.getNode().getOutputs()) {
			JSONObject newInput = new JSONObject();
			newInput.put("type", type.getClass().getSimpleName());
			newInput.put("_ref", "$" + (n++));
			newOutputs.add(newInput);
		}

		newMapping.put("input", newInputs);
		newMapping.put("output", newOutputs);
		if(node.getNode().getOutputs().length > 0) {
			newMapping.put("value", "$" + (n-1));
		}

		shortcut.put("input", jsonArray);
		shortcut.put("mapping", newMapping);
		return shortcut;
//		mapping.put(node.getName(), shortcut);
	}
}
