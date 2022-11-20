package net.andrewcpu.halo.nodes.nodes.events.player;

import net.andrewcpu.halo.nodes.OutputOnlyNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;

public class PlayerJoinedEvent extends OutputOnlyNode {
	public PlayerJoinedEvent() {
		super("Player Joined Event", new DataType[]{}, new DataType[]{new PlayerType("player"), new BooleanType("inProgress")});
	}
}
