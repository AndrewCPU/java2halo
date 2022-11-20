package net.andrewcpu.halo.nodes.nodes.players;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;
import net.andrewcpu.halo.type.VectorType;

public class TeleportPlayer extends IONode {
	public TeleportPlayer() {
		super("Teleport Player", new DataType[]{new PlayerType("player"), new VectorType("position"), new BooleanType("withVehicle")}, new DataType[]{});
	}
}
