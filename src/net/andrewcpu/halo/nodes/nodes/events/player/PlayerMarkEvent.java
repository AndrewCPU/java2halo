package net.andrewcpu.halo.nodes.nodes.events.player;

import net.andrewcpu.halo.nodes.OutputOnlyNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;
import net.andrewcpu.halo.type.PlayersType;
import net.andrewcpu.halo.type.VectorType;

public class PlayerMarkEvent extends OutputOnlyNode {
	public PlayerMarkEvent() {
		super("Player Mark Event", new DataType[]{}, new DataType[]{new PlayerType("player"), new VectorType("position"), new PlayersType("targets")});
	}
}
