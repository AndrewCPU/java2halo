package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.TeamType;

public class GetTeamVariable extends ISONode<TeamType>{
	public GetTeamVariable() {
		super("Get Team Variable", new TeamType("value"));
	}
}
