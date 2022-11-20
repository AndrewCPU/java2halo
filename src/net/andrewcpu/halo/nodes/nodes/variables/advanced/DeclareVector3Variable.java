package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.VectorType;

public class DeclareVector3Variable extends IISNode<VectorType> {
	public DeclareVector3Variable() {
		super("Declare Vector Variable ", new VectorType("initialValue"));
	}
}
