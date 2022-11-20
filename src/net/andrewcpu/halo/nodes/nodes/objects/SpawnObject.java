package net.andrewcpu.halo.nodes.nodes.objects;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectType;

public class SpawnObject extends IONode {
	public SpawnObject() {
		super("Spawn Object", new DataType[]{new ObjectType("object")}, new DataType[]{});
	}
}
