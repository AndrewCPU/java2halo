package net.andrewcpu.halo.nodes.nodes.objects;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectType;
import net.andrewcpu.halo.type.ObjectsType;

public class GetObjectsInPrefab extends DataNode {
	public GetObjectsInPrefab() {
		super("Get Objects in Prefab", new DataType[]{new ObjectType("object")}, new DataType[]{new ObjectsType("components")});
	}
}
