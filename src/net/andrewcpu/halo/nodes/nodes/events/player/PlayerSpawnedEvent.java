package net.andrewcpu.halo.nodes.nodes.events.player;

import net.andrewcpu.halo.nodes.OutputOnlyNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;

public class PlayerSpawnedEvent extends OutputOnlyNode {
	public PlayerSpawnedEvent() {
		super("Player Spawned Event", new DataType[]{}, new DataType[]{new PlayerType("player")});
	}
}
