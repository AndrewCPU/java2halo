package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.ObjectsType;

public class GetObjectListVariable extends ISONode<ObjectsType> {
	public GetObjectListVariable() {
		super("Get Object List Variable", new ObjectsType("value"));
	}
}
