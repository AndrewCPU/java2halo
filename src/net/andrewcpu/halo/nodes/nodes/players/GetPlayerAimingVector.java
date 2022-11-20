package net.andrewcpu.halo.nodes.nodes.players;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;
import net.andrewcpu.halo.type.VectorType;

public class GetPlayerAimingVector extends DataNode {
	public GetPlayerAimingVector() {
		super("Get Player Aiming Vector", new DataType[]{new PlayerType("player")}, new DataType[]{new VectorType("aimingVector")});
	}
}
