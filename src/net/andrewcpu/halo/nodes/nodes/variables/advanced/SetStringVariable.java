package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.StringType;

public class SetStringVariable extends IVSONode<StringType>{
	public SetStringVariable() {
		super("Set String Variable", new StringType("value"));
	}
}
