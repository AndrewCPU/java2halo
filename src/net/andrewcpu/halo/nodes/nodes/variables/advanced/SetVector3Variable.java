package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.VectorType;

public class SetVector3Variable extends IVSONode<VectorType>{
	public SetVector3Variable() {
		super("Set Vector3 Variable", new VectorType("value"));
	}
}
