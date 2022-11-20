package net.andrewcpu.halo.nodes.nodes.objects;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectType;
import net.andrewcpu.halo.type.ObjectsType;

public class AddObjectToList extends DataNode {
	public AddObjectToList() {
		super("Add Object to List", new DataType[]{new ObjectsType("objectList"), new ObjectType("object")}, new DataType[]{new ObjectsType("newList")});
	}
}
