package net.andrewcpu.halo.nodes;

import net.andrewcpu.halo.type.DataType;

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

}
