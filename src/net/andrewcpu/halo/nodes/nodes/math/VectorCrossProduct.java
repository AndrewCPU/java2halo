package net.andrewcpu.halo.nodes.nodes.math;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.VectorType;

public class VectorCrossProduct extends DataNode {
	public VectorCrossProduct() {
		super("Vector Cross Product", new DataType[]{new VectorType("a"), new VectorType("b")}, new DataType[]{new VectorType("crossProduct")});
	}
}
