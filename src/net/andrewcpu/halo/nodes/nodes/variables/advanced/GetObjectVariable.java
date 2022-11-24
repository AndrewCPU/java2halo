package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.ObjectType;

public class GetObjectVariable extends ISONode<ObjectType> {
	public GetObjectVariable() {
		super("Get Object Variable.json", new ObjectType("value"));
	}
}
