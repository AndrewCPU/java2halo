package net.andrewcpu.halo.nodes.nodes.game_mode.game;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;

public class SetRoundTime extends IONode {
	public SetRoundTime(){
		super("Set Round Time", new DataType[]{new NumberType("time")}, new DataType[]{});
	}
}
