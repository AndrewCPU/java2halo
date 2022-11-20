package net.andrewcpu.halo.nodemesh;

import net.andrewcpu.halo.nodes.nodes.inventory.*;
import net.andrewcpu.halo.type.WeaponType;

import java.util.List;

public class WeaponMaster extends MasterCollection<WeaponType> {
	@Override
	public Class<WeaponType> getDataType() {
		return WeaponType.class;
	}

	@Override
	public List<PrefillNodeValue> getters() {
		return List.of(
				PrefillNodeValue.of(AreSameWeaponType.class, 0, "areSameType"),
				PrefillNodeValue.of(GetIsWeaponType.class, 0, "isType"),
				PrefillNodeValue.of(GetWeaponMagazineCapacity.class,0, "getMagazineCapacity"),
				PrefillNodeValue.of(GetWeaponMagazineRounds.class,0, "getMagazineRounds"),
				PrefillNodeValue.of(GetWeaponType.class, 0, "getType")
		);
	}

	@Override
	public List<PrefillNodeValue> setters() {
		return List.of();
	}

	@Override
	public List<PrefillNodeValue> functions() {
		return List.of();
	}
}
