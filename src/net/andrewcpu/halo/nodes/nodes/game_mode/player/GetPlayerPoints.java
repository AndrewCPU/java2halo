package net.andrewcpu.halo.nodes.nodes.game_mode.player;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.PlayerType;

public class GetPlayerPoints extends DataNode {
	public GetPlayerPoints() {
		super("Get Player Points", new DataType[]{new PlayerType("player")}, new DataType[]{new NumberType("total"), new NumberType("round")});
	}
}
