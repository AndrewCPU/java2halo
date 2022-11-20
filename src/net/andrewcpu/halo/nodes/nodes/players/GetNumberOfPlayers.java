package net.andrewcpu.halo.nodes.nodes.players;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;

public class GetNumberOfPlayers extends DataNode {
	public GetNumberOfPlayers() {
		super("Get Number of Players", new DataType[]{}, new DataType[]{new NumberType("count")});
	}
}
