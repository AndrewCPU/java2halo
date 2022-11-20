package net.andrewcpu.halo.nodes.nodes.objects;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectType;
import net.andrewcpu.halo.type.TeamType;

public class GetObjectTeam extends DataNode {
	public GetObjectTeam() {
		super("Get Object Team", new DataType[]{new ObjectType("object")}, new DataType[]{new TeamType("team")});
	}
}
