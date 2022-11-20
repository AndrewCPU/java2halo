package net.andrewcpu.halo.nodes.nodes.players;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;

public class SetPlayerMarkOverride extends IONode {
	public SetPlayerMarkOverride() {
		super("Set Player Mark Override", new DataType[]{new PlayerType("player"), new BooleanType("override")}, new DataType[]{});
	}
}
