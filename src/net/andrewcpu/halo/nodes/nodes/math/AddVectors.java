package net.andrewcpu.halo.nodes.nodes.math;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.VectorType;

public class AddVectors extends DataNode {
	public AddVectors() {
		super("Add Vectors", new DataType[]{new VectorType("a"), new VectorType("b")}, new DataType[]{new VectorType("vector")});
	}
}
