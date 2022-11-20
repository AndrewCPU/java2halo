package net.andrewcpu.halo.nodes.nodes.players;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.PlayerType;

public class GetRespawnPenalty extends DataNode {
	public GetRespawnPenalty() {
		super("Get Respawn Penalty", new DataType[]{new PlayerType("player")}, new DataType[]{new NumberType("penalty")});
	}
}
