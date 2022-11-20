package net.andrewcpu.halo.nodes.nodes.inventory;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.PlayerType;

public class AddPlayerAmmoEquipped extends IONode {
	public AddPlayerAmmoEquipped() {
		super("Add Player Ammo - Equipped", new DataType[]{new PlayerType("player"), new NumberType("refillPercent")}, new DataType[]{});
	}
}
