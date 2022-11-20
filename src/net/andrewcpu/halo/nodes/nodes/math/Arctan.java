package net.andrewcpu.halo.nodes.nodes.math;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;

public class Arctan extends DataNode {
	public Arctan() {
		super("ArcTan", new DataType[]{new NumberType("a"), new NumberType("b")}, new DataType[]{new NumberType("arctan")});
	}
}
