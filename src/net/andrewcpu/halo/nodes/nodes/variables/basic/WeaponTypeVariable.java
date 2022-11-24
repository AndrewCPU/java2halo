package net.andrewcpu.halo.nodes.nodes.variables.basic;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.WeaponTypeType;

public class WeaponTypeVariable extends DataNode {
	public WeaponTypeVariable() {
		super("Weapon Type Variable.json", new DataType[]{new WeaponTypeType("value")}, new DataType[]{new WeaponTypeType("value")});
	}
}
