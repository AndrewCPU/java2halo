package net.andrewcpu.halo.nodes.nodes.variables.basic;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectType;
import net.andrewcpu.halo.type.ObjectsType;

public class ObjectListVariable extends DataNode {
	public ObjectListVariable() {
		super("Object List Variable", new DataType[]{new ObjectType("a"), new ObjectType("b"), new ObjectType("c"), new ObjectType("d")}, new DataType[]{new ObjectsType("objectList")});
	}
}
