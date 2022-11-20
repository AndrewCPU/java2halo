package net.andrewcpu.halo.nodes.nodes.math;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.VectorType;

public class SubtractVectors extends DataNode {
	public SubtractVectors() {
		super("Subtract Vectors", new DataType[]{new VectorType("a"), new VectorType("b")}, new DataType[]{new VectorType("vector")});
	}
}
