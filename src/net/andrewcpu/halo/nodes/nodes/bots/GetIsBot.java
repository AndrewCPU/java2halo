package net.andrewcpu.halo.nodes.nodes.bots;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;

public class GetIsBot extends DataNode {
	public GetIsBot() {
		super("Get is Bot", new DataType[]{new PlayerType("player")}, new DataType[]{new BooleanType("isBot")});
	}
}
