package net.andrewcpu.halo.nodes.nodes.objects;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectType;

public class AreSameObject extends DataNode {
	public AreSameObject() {
		super("Are Same Object", new DataType[]{new ObjectType("a"), new ObjectType("b")}, new DataType[]{new BooleanType("equal")});
	}
}
