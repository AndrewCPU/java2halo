package net.andrewcpu.halo.nodes.nodes.inventory;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.WeaponType;

public class GetWeaponMagazineRounds extends DataNode {
	public GetWeaponMagazineRounds() {
		super("Get Weapon Magazine Rounds", new DataType[]{new WeaponType("weapon")}, new DataType[]{new NumberType("rounds")});
	}
}
