package net.andrewcpu.halo.nodes.nodes.math;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.VectorType;

public class ScaleVector extends DataNode {
	public ScaleVector() {// vector, scalar
		super("Scale Vector", new DataType[]{new VectorType("vector"), new NumberType("scalar")}, new DataType[]{new VectorType("scaled")});
	}
}
