package net.andrewcpu.halo.nodes.nodes.game_mode.game;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;

public class EndRoundAllTie extends IONode {
	public EndRoundAllTie() {
		super("End Round - All Tie", new DataType[]{new BooleanType("endGame")}, new DataType[]{});
	}
}
