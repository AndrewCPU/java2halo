package net.andrewcpu.halo.type;

import net.andrewcpu.halo.nodes.Node;
import net.andrewcpu.halo.nodes.nodes.logic.BooleanLogic;
import net.andrewcpu.halo.nodes.nodes.logic.CompareEquipmentTypes;

public class EquipmentTypeType  extends DataType implements ComparableType{
	public EquipmentTypeType(String name) {
		super(name);
	}

	@Override
	public Class<? extends Node> getComparisonNode() {
		return CompareEquipmentTypes.class;
	}
}
