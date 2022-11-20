package net.andrewcpu.halo.nodes.nodes.players;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;
import net.andrewcpu.halo.type.TeamType;

public class GetPlayerTeam extends DataNode {
	public GetPlayerTeam() {
		super("Get Player Team", new DataType[]{new PlayerType("player")}, new DataType[]{new TeamType("team")});
	}
}
