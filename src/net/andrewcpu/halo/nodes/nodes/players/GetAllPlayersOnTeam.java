package net.andrewcpu.halo.nodes.nodes.players;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayersType;
import net.andrewcpu.halo.type.TeamType;

public class GetAllPlayersOnTeam extends DataNode {
	public GetAllPlayersOnTeam() {
		super("Get All Players on Team", new DataType[]{new TeamType("team")}, new DataType[]{new PlayersType("players")});
	}
}
