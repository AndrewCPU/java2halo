package net.andrewcpu.halo.nodes.nodes.variables.basic;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.WeaponConfigurationType;
import net.andrewcpu.halo.type.WeaponType;
import net.andrewcpu.halo.type.WeaponTypeType;

public class WeaponTypeCombinationVariable extends DataNode {
	public WeaponTypeCombinationVariable() {
		super("Weapon Type Combination Variable", new DataType[]{new WeaponType("baseWeapon"), new WeaponConfigurationType("configuration")}, new DataType[]{new WeaponTypeType("weaponType")});
	}
}
