package net.andrewcpu.halo.nodes;

import net.andrewcpu.halo.type.DataType;

public abstract class OutputOnlyNode extends Node{
	public OutputOnlyNode(String name, DataType[] inputs, DataType[] outputs) {
		super(name, inputs, outputs, false, true);
	}
}
