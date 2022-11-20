package net.andrewcpu.halo.nodes.nodes.objects;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectType;
import net.andrewcpu.halo.type.ObjectsType;

public class ObjectIsInList extends DataNode {
	public ObjectIsInList() {
		super("Object is in List", new DataType[]{new ObjectsType("objectList"), new ObjectType("object")}, new DataType[]{new BooleanType("inList")});
	}
}
