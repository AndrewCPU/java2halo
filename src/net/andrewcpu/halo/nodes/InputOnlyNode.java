package net.andrewcpu.halo.nodes;

import net.andrewcpu.halo.type.DataType;

public abstract class InputOnlyNode extends Node{
	public InputOnlyNode(String name, DataType[] inputs, DataType[] outputs) {
		super(name, inputs, outputs, true, false);
	}
}
