package net.andrewcpu.halo.nodes.nodes.math;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;

public class RandomBoolean extends DataNode {
	public RandomBoolean() {
		super("Random Boolean", new DataType[]{new NumberType("percentWeighting")}, new DataType[]{new BooleanType("boolean")});
	}
}
