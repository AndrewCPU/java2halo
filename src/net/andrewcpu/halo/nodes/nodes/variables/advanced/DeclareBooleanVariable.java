package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.BooleanType;

public class DeclareBooleanVariable extends IISNode<BooleanType> {
	public DeclareBooleanVariable() {
		super("Declare Boolean Variable ", new BooleanType("initialValue"));
	}
}
