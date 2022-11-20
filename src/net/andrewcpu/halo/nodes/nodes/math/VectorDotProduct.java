package net.andrewcpu.halo.nodes.nodes.math;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.VectorType;

public class VectorDotProduct extends DataNode {
	public VectorDotProduct() {
		super("Vector Dot Product", new DataType[]{new VectorType("a"), new VectorType("b")}, new DataType[]{new NumberType("number")});
	}
}
