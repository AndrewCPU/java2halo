package net.andrewcpu.halo.nodes.nodes.events.player;

import net.andrewcpu.halo.nodes.OutputOnlyNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.DeathContextType;
import net.andrewcpu.halo.type.PlayerType;

public class PlayerKilledEvent extends OutputOnlyNode {
	public PlayerKilledEvent() {
		super("Player Killed Event", new DataType[]{}, new DataType[]{new PlayerType("killed"), new PlayerType("killer"), new DeathContextType("deathContext")});
	}
}
