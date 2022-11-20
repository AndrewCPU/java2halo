package net.andrewcpu.halo.nodes.nodes.game_mode.game;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;

public class SetPointsToWin extends IONode {
	public SetPointsToWin() {
		super("Set Points to Win", new DataType[]{new NumberType("points")}, new DataType[]{});
	}
}
