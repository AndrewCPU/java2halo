package net.andrewcpu.halo.nodes.nodes.math;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;

public class AbsoluteValue extends DataNode {
	public AbsoluteValue() {
		super("Absolute Value", new DataType[]{new NumberType("number")}, new DataType[]{new NumberType("number")});
	}
}
