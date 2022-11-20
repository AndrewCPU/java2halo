package net.andrewcpu.halo.nodes.nodes.inventory;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.*;

public class GivePlayerSpecificWeapon extends IONode {
	public GivePlayerSpecificWeapon() {
		super("Give Player Specific Weapon", new DataType[]{new PlayerType("player"), new WeaponType("weapon"), new WeaponAdditionMethodType("additionMethod"), new BooleanType("waitUntilComplete")}, new DataType[]{});
	}
}
