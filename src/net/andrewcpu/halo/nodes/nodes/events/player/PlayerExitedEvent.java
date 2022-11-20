package net.andrewcpu.halo.nodes.nodes.events.player;

import net.andrewcpu.halo.nodes.OutputOnlyNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;
import net.andrewcpu.halo.type.TeamType;

public class PlayerExitedEvent extends OutputOnlyNode {
	public PlayerExitedEvent() {
		super("Player Exited Event", new DataType[]{}, new DataType[]{new PlayerType("player"), new TeamType("team")});
	}
}
