package net.andrewcpu.halo.nodes.nodes.objects;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.ObjectsType;

public class GetListSize extends DataNode {
	public GetListSize() {
		super("Get List Size", new DataType[]{new ObjectsType("list")}, new DataType[]{new NumberType("size")});
	}
}
