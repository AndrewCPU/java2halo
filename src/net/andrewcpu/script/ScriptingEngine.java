package net.andrewcpu.script;

import net.andrewcpu.halo.nodes.AllNodes;
import net.andrewcpu.halo.nodes.Node;
import org.json.simple.JSONObject;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class ScriptingEngine {
	public static void main(String[] args) throws Exception{

		JSONObject output = new JSONObject();
		output.put("nodes", 		AllNodes.getAllNodes().stream().map(clazz -> {
			try {
				System.out.println(clazz);
				Node node = (Node) (clazz.getConstructors()[0].newInstance());
				return node.toJSON();
//				System.out.println(node.toJSON().toJSONString());
			} catch (InstantiationException e) {
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			} catch (InvocationTargetException e) {
				throw new RuntimeException(e);
			}
		}).collect(Collectors.toList()));
		System.out.println(output.toJSONString());

	}
}
