package net.andrewcpu.halo.nodes.nodes.game_mode.team;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.TeamType;

public class GetTeamPoints extends DataNode {
	public GetTeamPoints() {
		super("Get Team Points", new DataType[]{new TeamType("team")}, new DataType[]{new NumberType("total"), new NumberType("round")});
	}
}
