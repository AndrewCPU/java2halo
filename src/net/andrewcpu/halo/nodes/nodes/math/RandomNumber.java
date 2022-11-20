package net.andrewcpu.halo.nodes.nodes.math;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;

public class RandomNumber extends DataNode {
	public RandomNumber() {
		super("Random", new DataType[]{new NumberType("min"), new NumberType("max")}, new DataType[]{new NumberType("number")});
	}
}
