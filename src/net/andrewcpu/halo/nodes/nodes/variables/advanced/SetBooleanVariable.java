package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.BooleanType;

public class SetBooleanVariable extends IVSONode<BooleanType>{
	public SetBooleanVariable() {
		super("Set Boolean Variable.json", new BooleanType("value"));
	}
}
