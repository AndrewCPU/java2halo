package net.andrewcpu.halo.nodes.nodes.game_mode.game;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;

public class EndRoundAllLose extends IONode {
	public EndRoundAllLose() {
		super("End Round - All Lose", new DataType[]{new BooleanType("endGame")}, new DataType[]{});
	}
}
