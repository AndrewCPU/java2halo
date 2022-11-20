package net.andrewcpu.halo.nodes.nodes.math;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;

public class CosSinTan extends DataNode {
	public CosSinTan() {// out cos sin tan
		super("Cos Sin Tan", new DataType[]{new NumberType("number")}, new DataType[]{new NumberType("cos"), new NumberType("sin"), new NumberType("tan")});
	}
}
