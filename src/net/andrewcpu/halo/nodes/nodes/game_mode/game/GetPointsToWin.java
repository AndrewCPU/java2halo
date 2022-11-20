package net.andrewcpu.halo.nodes.nodes.game_mode.game;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;

public class GetPointsToWin extends DataNode {
	public GetPointsToWin() {
		super("Get Points to Win", new DataType[]{}, new DataType[]{new NumberType("points")});
	}
}
