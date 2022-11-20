package net.andrewcpu.halo.nodes.nodes.objects;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectsType;

public class GetSharedObjects extends DataNode {
	public GetSharedObjects() {
		super("Get Shared Objects", new DataType[]{new ObjectsType("a"), new ObjectsType("b")}, new DataType[]{new ObjectsType("shared")});
	}
}
