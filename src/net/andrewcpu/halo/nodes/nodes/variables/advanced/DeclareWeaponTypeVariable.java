package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.WeaponTypeType;

public class DeclareWeaponTypeVariable extends IISNode<WeaponTypeType> {
	public DeclareWeaponTypeVariable() {
		super("Declare Weapon Type Variable.json ", new WeaponTypeType("initialValue"));
	}
}
