package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.StringType;

public class DeclareStringVariable extends IISNode<StringType> {
	public DeclareStringVariable() {
		super("Declare String Variable.json ", new StringType("initialValue"));
	}
}
