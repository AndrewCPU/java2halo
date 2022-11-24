package net.andrewcpu.halo.nodes.nodes.variables.basic;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;

public class BooleanVariable extends DataNode {
	public BooleanVariable() {
		super("Boolean Variable.json", new DataType[]{new BooleanType("value")}, new DataType[]{new BooleanType("value")});
	}
}
