package net.andrewcpu.halo.nodes.nodes.objects;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectsType;

public class GetAllSpawnPoints extends DataNode {
	public GetAllSpawnPoints() {
		super("Get All Spawn Points", new DataType[]{}, new DataType[]{new ObjectsType("spawnPoints")});
	}
}
