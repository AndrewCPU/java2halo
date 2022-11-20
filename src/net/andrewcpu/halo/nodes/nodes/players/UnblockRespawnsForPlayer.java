package net.andrewcpu.halo.nodes.nodes.players;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;

public class UnblockRespawnsForPlayer extends IONode {
	public UnblockRespawnsForPlayer() {
		super("Unblock Respawns for Player", new DataType[]{new PlayerType("player")}, new DataType[]{});
	}
}
