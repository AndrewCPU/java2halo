package net.andrewcpu.halo.nodes.nodes.players;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayersType;

public class GetAllPlayers extends DataNode {
	public GetAllPlayers() {
		super("Get all Players", new DataType[]{}, new DataType[]{new PlayersType("players")});
	}
}
