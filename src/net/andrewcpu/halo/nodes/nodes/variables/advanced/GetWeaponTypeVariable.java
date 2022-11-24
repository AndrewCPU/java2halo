package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.WeaponTypeType;

public class GetWeaponTypeVariable extends ISONode<WeaponTypeType> {
	public GetWeaponTypeVariable() {
		super("Get Weapon Type Variable.json", new WeaponTypeType("value"));
	}
}
