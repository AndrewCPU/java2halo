package net.andrewcpu.halo.type;

import net.andrewcpu.halo.nodes.Node;
import net.andrewcpu.halo.nodes.nodes.logic.BooleanLogic;
import net.andrewcpu.halo.nodes.nodes.logic.CompareGrenadeTypes;

public class GrenadeTypeType extends DataType implements ComparableType{
	public GrenadeTypeType(String name) {
		super(name);
	}

	@Override
	public Class<? extends Node> getComparisonNode() {
		return CompareGrenadeTypes.class;
	}
}
