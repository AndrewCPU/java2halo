package net.andrewcpu.halo.type;

import net.andrewcpu.halo.nodes.Node;
import net.andrewcpu.halo.nodes.nodes.logic.BooleanLogic;
import net.andrewcpu.halo.nodes.nodes.logic.CompareVehicleTypes;

public class VehicleTypeType extends DataType implements ComparableType{
	public VehicleTypeType(String name) {
		super(name);
	}

	@Override
	public Class<? extends Node> getComparisonNode() {
		return CompareVehicleTypes.class;
	}

}
