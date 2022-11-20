package net.andrewcpu.halo.nodes.nodes.players;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;
import net.andrewcpu.halo.type.TeamType;

public class SetPlayerTeam extends IONode {
	public SetPlayerTeam() {
		super("Set Player Team", new DataType[]{new PlayerType("player"), new TeamType("team")}, new DataType[]{});
	}
}
