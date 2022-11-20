package net.andrewcpu.halo.nodes.nodes.players;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.PlayerType;

public class SetRespawnPenalty extends IONode {
	public SetRespawnPenalty() {
		super("Set Respawn Penalty", new DataType[]{new PlayerType("player"), new NumberType("seconds")}, new DataType[]{});
	}
}
