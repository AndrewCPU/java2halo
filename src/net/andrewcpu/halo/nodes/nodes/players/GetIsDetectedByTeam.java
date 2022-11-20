package net.andrewcpu.halo.nodes.nodes.players;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;
import net.andrewcpu.halo.type.TeamType;

public class GetIsDetectedByTeam extends DataNode {
	public GetIsDetectedByTeam(){
		super("Get is Detected By Team", new DataType[]{new PlayerType("player"), new TeamType("team")}, new DataType[]{new BooleanType("isDetected")});
	}
}
