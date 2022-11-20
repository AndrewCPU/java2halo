package net.andrewcpu.halo.nodes.nodes.math;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.VectorType;

public class GetVectorLength extends DataNode {
	public GetVectorLength() {
		super("Get Vector Length", new DataType[]{new VectorType("vector")}, new DataType[]{new NumberType("length")});
	}
}
