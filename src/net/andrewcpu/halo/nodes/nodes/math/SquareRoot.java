package net.andrewcpu.halo.nodes.nodes.math;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;

public class SquareRoot extends DataNode {
	public SquareRoot() {
		super("Square Root", new DataType[]{new NumberType("number")}, new DataType[]{new NumberType("root")});
	}
}
