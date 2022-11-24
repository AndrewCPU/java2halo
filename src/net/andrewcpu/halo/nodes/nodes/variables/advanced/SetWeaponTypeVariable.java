package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.WeaponTypeType;

public class SetWeaponTypeVariable extends IVSONode<WeaponTypeType>{
	public SetWeaponTypeVariable() {
		super("Set Weapon Type Variable.json", new WeaponTypeType("value"));
	}
}
