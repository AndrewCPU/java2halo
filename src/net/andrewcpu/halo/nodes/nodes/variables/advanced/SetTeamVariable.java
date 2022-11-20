package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.TeamType;

public class SetTeamVariable extends IVSONode<TeamType>{
	public SetTeamVariable() {
		super("Set Team Variable", new TeamType("value"));
	}
}
