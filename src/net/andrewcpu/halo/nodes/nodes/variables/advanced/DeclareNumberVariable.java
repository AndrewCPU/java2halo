package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.NumberType;

public class DeclareNumberVariable extends IISNode<NumberType> {
	public DeclareNumberVariable() {
		super("Declare Number Variable ", new NumberType("initialValue"));
	}
}
