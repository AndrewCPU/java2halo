package net.andrewcpu.halo.nodes.nodes.players;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;

public class AreSamePlayer extends DataNode {
	public AreSamePlayer() {
		super("Are Same Player", new DataType[]{new PlayerType("a"), new PlayerType("b")}, new DataType[]{new BooleanType("equal")});
	}
}
