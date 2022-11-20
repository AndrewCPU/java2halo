package net.andrewcpu.halo.nodes.nodes.inventory;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.*;

public class GivePlayerNewWeapon extends IONode {
	public GivePlayerNewWeapon() {
		super("Give Player New Weapon", new DataType[]{new PlayerType("player"), new WeaponTypeType("weaponType"), new WeaponAdditionMethodType("additionMethod"), new BooleanType("waitUntilComplete")}, new DataType[]{});
	}
}
