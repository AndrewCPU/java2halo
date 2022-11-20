package net.andrewcpu.halo.nodes.nodes.inventory;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;

public class EmptyPlayerAmmo extends IONode {
	public EmptyPlayerAmmo() {
		super("Empty Player Ammo", new DataType[]{new PlayerType("player")}, new DataType[]{});
	}
}
