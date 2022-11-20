package net.andrewcpu.halo.nodes.nodes.objects;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.ObjectType;
import net.andrewcpu.halo.type.ObjectsType;

public class GetObjectAtIndex extends DataNode {
	public GetObjectAtIndex() {
		super("Get Object at Index", new DataType[]{new ObjectsType("objectList"), new NumberType("index")}, new DataType[]{new ObjectType("object")});
	}
}
