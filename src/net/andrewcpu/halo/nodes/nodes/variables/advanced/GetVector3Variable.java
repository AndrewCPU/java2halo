package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.VectorType;

public class GetVector3Variable extends ISONode<VectorType> {
	public GetVector3Variable() {
		super("Get Vector Variable.json", new VectorType("value"));
	}
}
