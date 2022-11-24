package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.NumberType;

public class SetNumberVariable extends IVSONode<NumberType>{
	public SetNumberVariable() {
		super("Set Number Variable.json", new NumberType("value"));
	}
}
