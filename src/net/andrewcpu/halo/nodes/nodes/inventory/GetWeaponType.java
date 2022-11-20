package net.andrewcpu.halo.nodes.nodes.inventory;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.WeaponConfigurationType;
import net.andrewcpu.halo.type.WeaponType;
import net.andrewcpu.halo.type.WeaponTypeType;

public class GetWeaponType extends DataNode {
	public GetWeaponType() {
		super("Get Weapon Type", new DataType[]{new WeaponType("weapon")}, new DataType[]{new WeaponTypeType("type"), new WeaponTypeType("baseWeapon"), new WeaponConfigurationType("configuration")});
	}
}
