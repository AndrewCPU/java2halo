package net.andrewcpu.halo.nodes.nodes.variables.basic;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectType;

public class ObjectReferenceVariable extends DataNode {
	public ObjectReferenceVariable() {
		super("Object Reference Variable", new DataType[]{new ObjectType("value")}, new DataType[]{new ObjectType("value")});
	}
}
