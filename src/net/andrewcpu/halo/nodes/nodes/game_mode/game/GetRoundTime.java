package net.andrewcpu.halo.nodes.nodes.game_mode.game;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;

public class GetRoundTime extends DataNode {
	public GetRoundTime() {
		super("Get Round Time", new DataType[]{}, new DataType[]{new NumberType("time")});
	}
}
