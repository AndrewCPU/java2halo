package net.andrewcpu.halo.nodes.nodes.game_mode.player;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.PlayerType;

public class AdjustPersonalScore extends IONode {
	public AdjustPersonalScore() {
		super("Adjust Personal Score", new DataType[]{new PlayerType("player"), new NumberType("adjustment")}, new DataType[]{});
	}
}
