package net.andrewcpu.halo.nodes.nodes.inventory;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.PlayerType;

public class AddPlayerAmmoUnequipped extends IONode {
	public AddPlayerAmmoUnequipped() {
		super("Add Player Ammo - Unequipped", new DataType[]{new PlayerType("player"), new NumberType("refillPercent")}, new DataType[]{});
	}
}
