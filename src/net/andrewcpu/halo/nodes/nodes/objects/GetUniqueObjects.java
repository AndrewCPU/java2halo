package net.andrewcpu.halo.nodes.nodes.objects;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectsType;

public class GetUniqueObjects extends DataNode {
	public GetUniqueObjects() {
		super("Get Unique Objects", new DataType[]{new ObjectsType("a"), new ObjectsType("b")}, new DataType[]{new ObjectsType("unique")});
	}
}
