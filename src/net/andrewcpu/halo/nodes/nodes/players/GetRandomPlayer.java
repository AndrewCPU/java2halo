package net.andrewcpu.halo.nodes.nodes.players;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;

public class GetRandomPlayer extends DataNode {
	public GetRandomPlayer() {
		super("Get Random Player", new DataType[]{}, new DataType[]{new PlayerType("player")});
	}
}
