package net.andrewcpu.halo.nodes.nodes.math;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;

public class RoundToWholeNumber extends DataNode {
	public RoundToWholeNumber() {// round up, nearest, round down
		super("Round to Whole Number", new DataType[]{new NumberType("number")}, new DataType[]{new NumberType("up"), new NumberType("nearest"), new NumberType("down")});
	}
}
