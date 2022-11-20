package net.andrewcpu.halo.nodes.nodes.math;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.VectorType;

public class NormalizeVector extends DataNode {
	public NormalizeVector() {
		super("Normalize Vector", new DataType[]{new VectorType("vector")}, new DataType[]{new VectorType("normalizedVector")});
	}
}
