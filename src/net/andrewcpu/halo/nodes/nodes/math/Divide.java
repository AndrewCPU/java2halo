package net.andrewcpu.halo.nodes.nodes.math;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;

public class Divide extends DataNode {
	public Divide() {
		super("Divide", new DataType[]{new NumberType("a"), new NumberType("b")}, new DataType[]{new NumberType("quotient"), new NumberType("whole"), new NumberType("remainder")});
	}
}
