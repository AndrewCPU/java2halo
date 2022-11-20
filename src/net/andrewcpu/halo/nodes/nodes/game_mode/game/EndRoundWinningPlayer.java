package net.andrewcpu.halo.nodes.nodes.game_mode.game;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;

public class EndRoundWinningPlayer extends IONode {
	public EndRoundWinningPlayer() {
		super("End Round - Winning Player", new DataType[]{new PlayerType("winner"), new BooleanType("endGame")}, new DataType[]{});
	}
}
