package net.andrewcpu.halo.nodes.nodes.inventory;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.WeaponType;

public class AreSameWeaponType extends DataNode {
	public AreSameWeaponType() {
		super("Are Same Weapon Type", new DataType[]{new WeaponType("a"), new WeaponType("b")}, new DataType[]{new BooleanType("sameBase"), new BooleanType("sameType")});
	}
}
