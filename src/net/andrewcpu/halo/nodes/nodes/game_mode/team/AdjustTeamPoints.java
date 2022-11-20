package net.andrewcpu.halo.nodes.nodes.game_mode.team;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.TeamType;

public class AdjustTeamPoints extends IONode {
	public AdjustTeamPoints() {
		super("Adjust Team Points", new DataType[]{new TeamType("team"), new NumberType("adjustment")}, new DataType[]{});
	}
}
