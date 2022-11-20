package net.andrewcpu.halo.nodes.nodes.inventory;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.WeaponType;

public class GetWeaponMagazineCapacity extends DataNode {
	public GetWeaponMagazineCapacity() {
		super("Get Weapon Magazine Capacity", new DataType[]{new WeaponType("weapon")}, new DataType[]{new NumberType("capacity")});
	}
}
