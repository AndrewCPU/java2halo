package net.andrewcpu.halo.nodes.nodes.events.player;

import net.andrewcpu.halo.nodes.OutputOnlyNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;
import net.andrewcpu.halo.type.TeamType;

public class PlayerTeamChangeEvent extends OutputOnlyNode {
	public PlayerTeamChangeEvent() {
		super("Player Team Change Event", new DataType[]{}, new DataType[]{new PlayerType("player"), new TeamType("old"), new TeamType("new")});
	}
}
