package net.andrewcpu.halo.type;

import net.andrewcpu.halo.nodes.Node;
import net.andrewcpu.halo.nodes.nodes.logic.BooleanLogic;
import net.andrewcpu.halo.nodes.nodes.logic.CompareWeaponTypes;

public class WeaponTypeType extends DataType implements ComparableType{
	public WeaponTypeType(String name) {
		super(name);
	}

	@Override
	public Class<? extends Node> getComparisonNode() {
		return CompareWeaponTypes.class;
	}
}
