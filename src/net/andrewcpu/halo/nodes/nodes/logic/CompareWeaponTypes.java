package net.andrewcpu.halo.nodes.nodes.logic;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.WeaponTypeType;

public class CompareWeaponTypes extends DataNode {
	public CompareWeaponTypes() {
		super("Compare Weapon Types", new DataType[]{new WeaponTypeType("a"), new WeaponTypeType("b")}, new DataType[]{new BooleanType("equal")});
	}
}
