package net.andrewcpu.halo.nodes;

import net.andrewcpu.halo.type.DataType;

public abstract class DataNode extends Node{
	public DataNode(String name, DataType[] inputs, DataType[] outputs) {
		super(name, inputs, outputs, false, false);
	}
}
