package net.andrewcpu.halo.nodes.nodes.objects;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectsType;
import net.andrewcpu.halo.type.TeamType;

public class GetAllSpawnPointsForTeam extends DataNode {
	public GetAllSpawnPointsForTeam(){
		super("Get All Spawn Points for Team", new DataType[]{new TeamType("team")}, new DataType[]{new ObjectsType("spawnPoints")});
	}
}
