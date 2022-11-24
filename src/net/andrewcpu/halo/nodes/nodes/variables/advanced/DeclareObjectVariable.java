package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.ObjectType;

public class DeclareObjectVariable extends IISNode<ObjectType> {
	public DeclareObjectVariable() {
		super("Declare Object Variable.json", new ObjectType("initialValue"));
	}
}
