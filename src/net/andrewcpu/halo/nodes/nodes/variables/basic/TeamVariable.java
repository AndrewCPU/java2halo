package net.andrewcpu.halo.nodes.nodes.variables.basic;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.TeamType;

public class TeamVariable extends DataNode {
	public TeamVariable() {
		super("Team Variable.json", new DataType[]{new TeamType("value")}, new DataType[]{new TeamType("value")});
	}
}
