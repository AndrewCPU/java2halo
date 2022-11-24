package net.andrewcpu.halo.nodes.nodes.variables.basic;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.VectorType;

public class Vector3Variable extends DataNode {
	public Vector3Variable() {
		super("Vector3 Variable.json", new DataType[]{new NumberType("x"), new NumberType("y"), new NumberType("z")}, new DataType[]{new VectorType("vector")});
	}
}
