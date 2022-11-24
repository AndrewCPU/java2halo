package net.andrewcpu.halo.type;

import net.andrewcpu.halo.nodes.Node;
import net.andrewcpu.halo.nodes.nodes.logic.BooleanLogic;
import net.andrewcpu.halo.nodes.nodes.logic.CompareTeams;

public class TeamType  extends DataType implements ComparableType{
	public TeamType(String name) {
		super(name);
	}

	@Override
	public Class<? extends Node> getComparisonNode() {
		return CompareTeams.class;
	}
}
