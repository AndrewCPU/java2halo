package net.andrewcpu.halo.nodes.nodes.inventory;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.WeaponType;
import net.andrewcpu.halo.type.WeaponTypeType;

public class GetIsWeaponType extends DataNode {
	public GetIsWeaponType() {
		super("Get is Weapon Type", new DataType[]{new WeaponType("weapon"), new WeaponTypeType("weaponType")}, new DataType[]{new BooleanType("isType")});
	}
}
