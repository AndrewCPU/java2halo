package net.andrewcpu.halo.nodes.nodes.variables.basic;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;

public class NumberVariable extends DataNode {
	public NumberVariable() {
		super("Number Variable", new DataType[]{new NumberType("value")}, new DataType[]{new NumberType("value")});
	}
}
