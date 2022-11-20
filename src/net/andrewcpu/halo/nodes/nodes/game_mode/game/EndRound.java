package net.andrewcpu.halo.nodes.nodes.game_mode.game;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;

public class EndRound extends IONode {
	public EndRound() {
		super("End Round", new DataType[]{new BooleanType("endGame")}, new DataType[]{});
	}
}
