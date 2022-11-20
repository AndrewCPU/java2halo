package net.andrewcpu.halo.nodes.nodes.game_mode.game;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;

public class GetCurrentRound extends DataNode {
	public GetCurrentRound() {
		super("Get Current Round", new DataType[]{}, new DataType[]{new NumberType("round")});
	}
}
