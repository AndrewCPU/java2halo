package net.andrewcpu.halo.nodes.nodes.variables.basic;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.StringType;

public class StringVariable extends DataNode {
	public StringVariable() {
		super("String Variable", new DataType[]{new StringType("value")}, new DataType[]{new StringType("value")});
	}
}
