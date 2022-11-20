package net.andrewcpu.halo.nodes.nodes.players;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;
import net.andrewcpu.halo.type.RespawnMessageType;

public class BlockPlayerRespawns extends IONode {
	public BlockPlayerRespawns() {
		super("Block Player Respawns", new DataType[]{new PlayerType("player"), new RespawnMessageType("respawnMessage")}, new DataType[]{});
	}
}
