package net.andrewcpu.halo.nodes.nodes.math;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;

public class Multiply extends DataNode {
	public Multiply() {
		super("Multiply", new DataType[]{new NumberType("a"), new NumberType("b")}, new DataType[]{new NumberType("number")});
	}
}
