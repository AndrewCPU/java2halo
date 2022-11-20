package net.andrewcpu.halo.nodes.nodes.math;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.VectorType;

public class GetVectorAxisValue extends DataNode {
	public GetVectorAxisValue() {
		super("Get Vector Axis Value", new DataType[]{new VectorType("vector")}, new DataType[]{new NumberType("x"), new NumberType("y"), new NumberType("z")});
	}
}
