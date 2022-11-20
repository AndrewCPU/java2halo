package net.andrewcpu.halo.nodes.nodes.inventory;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;
import net.andrewcpu.halo.type.WeaponType;

public class DropSpecificWeapon extends IONode {
	public DropSpecificWeapon() {
		super("Drop Specific Weapon", new DataType[]{new PlayerType("player"), new WeaponType("weapon")}, new DataType[]{});
	}
}
