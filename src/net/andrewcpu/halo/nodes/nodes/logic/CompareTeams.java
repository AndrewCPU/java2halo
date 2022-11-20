package net.andrewcpu.halo.nodes.nodes.logic;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.TeamType;

public class CompareTeams extends DataNode {
	public CompareTeams() {
		super("Compare Teams", new DataType[]{new TeamType("a"), new TeamType("b")}, new DataType[]{new BooleanType("equal")});
	}
}
