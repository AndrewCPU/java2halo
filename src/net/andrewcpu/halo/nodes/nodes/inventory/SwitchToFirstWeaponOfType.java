package net.andrewcpu.halo.nodes.nodes.inventory;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;
import net.andrewcpu.halo.type.WeaponTypeType;

public class SwitchToFirstWeaponOfType extends IONode {
	public SwitchToFirstWeaponOfType() {
		super("Switch to First Weapon of Type", new DataType[]{new PlayerType("player"), new WeaponTypeType("weaponType")}, new DataType[]{} );
	}
}
