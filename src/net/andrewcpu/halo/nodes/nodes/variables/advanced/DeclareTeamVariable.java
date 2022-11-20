package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.TeamType;

public class DeclareTeamVariable extends IISNode<TeamType> {
	public DeclareTeamVariable() {
		super("Declare Team Variable ", new TeamType("initialValue"));
	}
}
