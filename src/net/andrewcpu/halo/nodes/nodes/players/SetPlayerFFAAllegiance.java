package net.andrewcpu.halo.nodes.nodes.players;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;
import net.andrewcpu.halo.type.TeamType;

public class SetPlayerFFAAllegiance extends IONode {
	public SetPlayerFFAAllegiance() {
		super("Set Player FFA Allegiance", new DataType[]{new PlayerType("player"), new TeamType("team")}, new DataType[]{});
	}
}
