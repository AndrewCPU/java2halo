package net.andrewcpu.halo.nodes;

import net.andrewcpu.halo.type.DataType;

public class IONode extends Node{
	public IONode(String name, DataType[] inputs, DataType[] outputs) {
		super(name, inputs, outputs, true, true);
	}
}
