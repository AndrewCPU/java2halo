package net.andrewcpu.halo.nodes;

import net.andrewcpu.halo.type.DataType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public abstract class Node {
	private String name;
	private DataType[] inputs;
	private DataType[] outputs;

	private boolean receivesRunEvent;
	private boolean producesRunEvent;

	public Node(String name, DataType[] inputs, DataType[] outputs, boolean receives, boolean produces) {
		this.name = name;
		this.inputs = inputs;
		this.outputs = outputs;
		this.receivesRunEvent = receives;
		this.producesRunEvent = produces;
	}

	public boolean isReceivesRunEvent() {
		return receivesRunEvent;
	}

	public boolean isProducesRunEvent() {
		return producesRunEvent;
	}

	public String getName() {
		return name;
	}

	public DataType[] getInputs() {
		return inputs;
	}

	public DataType[] getOutputs() {
		return outputs;
	}

	public boolean canCarryLogic() {
		return producesRunEvent;
	}

	public JSONObject toJSON() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("type", getClass().getSimpleName());
		jsonObject.put("name", getName());

		JSONArray jsonArray = new JSONArray();
		for (DataType type : getInputs()) {
			JSONObject inputs = new JSONObject();
			inputs.put(type.getName(), type.getClass().getSimpleName().replaceFirst("Type", ""));
			jsonArray.add(inputs);
		}
		jsonObject.put("inputs", jsonArray);
		JSONArray outputs = new JSONArray();
		for(DataType type: getOutputs()) {
			JSONObject output = new JSONObject();
			output.put(type.getName(), type.getClass().getSimpleName().replaceFirst("Type",""));
			outputs.add(output);
		}
		jsonObject.put("outputs", outputs);
		jsonObject.put("has_execution_flow", canCarryLogic());
		jsonObject.put("receives_execution_flow", receivesRunEvent);
		jsonObject.put("produces_execution_flow", producesRunEvent);
		return jsonObject;
	}

}
