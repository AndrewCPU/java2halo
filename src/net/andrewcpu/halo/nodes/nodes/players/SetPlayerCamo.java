package net.andrewcpu.halo.nodes.nodes.players;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.PlayerType;

public class SetPlayerCamo extends IONode {
	public SetPlayerCamo() {
		super("Set Player Camo", new DataType[]{new PlayerType("player"), new NumberType("seconds")}, new DataType[]{});
	}
}
