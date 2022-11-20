package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.ObjectType;

public class SetObjectVariable extends IVSONode<ObjectType>{
	public SetObjectVariable() {
		super("Set Object Variable", new ObjectType("value"));
	}
}
