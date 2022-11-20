package net.andrewcpu.halo.nodes.nodes.objects;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.ObjectsType;

public class GetRandomNObjects extends DataNode {
	public GetRandomNObjects() {
		super("Get Random N Objects", new DataType[]{new ObjectsType("objectList"), new NumberType("n")}, new DataType[]{new ObjectsType("randomList")});
	}
}
