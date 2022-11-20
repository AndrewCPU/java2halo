package net.andrewcpu.halo.nodes.nodes.inventory;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;

public class RefillPlayerAmmo extends IONode {
	public RefillPlayerAmmo() {
		super("Refill Player Ammo", new DataType[]{new PlayerType("player")}, new DataType[]{});
	}
}
