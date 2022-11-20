package net.andrewcpu.halo.nodes.nodes.game_mode.game;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;

public class GetMaxRounds extends DataNode {
	public GetMaxRounds(){
		super("Get Max Rounds", new DataType[]{}, new DataType[]{new NumberType("maxRounds")});
	}
}
