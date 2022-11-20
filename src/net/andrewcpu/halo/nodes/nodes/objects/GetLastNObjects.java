package net.andrewcpu.halo.nodes.nodes.objects;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.ObjectsType;

public class GetLastNObjects extends DataNode {
	public GetLastNObjects() {
		super("Get Last N Objects", new DataType[]{new ObjectsType("objectList"), new NumberType("n")}, new DataType[]{new ObjectsType("list")});
	}
}
