package net.andrewcpu.halo.nodes.nodes.traits;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.TraitType;
import net.andrewcpu.halo.type.WeaponTypeType;

public class TraitLoadoutWeaponOverrides extends DataNode {
	public TraitLoadoutWeaponOverrides () {
		super("Trait: Loadout Weapon Overrides", new DataType[]{new WeaponTypeType("primaryWeaponType"), new WeaponTypeType("secondaryWeaponType")}, new DataType[]{new TraitType("trait")});
	}
}
