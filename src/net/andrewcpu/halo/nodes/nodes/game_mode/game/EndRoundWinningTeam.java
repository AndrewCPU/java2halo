package net.andrewcpu.halo.nodes.nodes.game_mode.game;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.TeamType;

public class EndRoundWinningTeam extends IONode {
	public EndRoundWinningTeam() {
		super("End Round - Winning Team", new DataType[]{new TeamType("winner"), new BooleanType("endGame")}, new DataType[]{});
	}
}
