package net.andrewcpu.halo.type;

import net.andrewcpu.halo.nodes.Node;
import net.andrewcpu.halo.nodes.nodes.logic.BooleanLogic;
import net.andrewcpu.halo.nodes.nodes.players.AreSamePlayer;

public class PlayerType extends DataType implements ComparableType{
	public PlayerType(String name) {
		super(name);
	}

	@Override
	public Class<? extends Node> getComparisonNode() {
		return AreSamePlayer.class;
	}
}
