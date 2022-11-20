package net.andrewcpu.script.highlevel.types;

import net.andrewcpu.halo.nodes.nodes.logic.CompareEquipmentTypes;
import net.andrewcpu.halo.type.EquipmentTypeType;
import net.andrewcpu.script.highlevel.HighLevelObject;
import net.andrewcpu.script.highlevel.SimpleNodeBundle;
import net.andrewcpu.script.highlevel.TypedFunctionResult;
import net.andrewcpu.script.highlevel.interfaces.HaloComparable;
import net.andrewcpu.script.highlevel.interfaces.HaloConstant;

public class EquipmentType extends HighLevelObject<EquipmentTypeType> implements HaloComparable<EquipmentTypeType, EquipmentType, CompareEquipmentTypes>, HaloConstant<EquipmentTypeType, EquipmentType> {
	public EquipmentType() {
		super(false);
	}

	@Override
	public java.lang.String[] getConstants() {
		return new java.lang.String[]{
				"active_camo",
				"drop_wall",
				"grappleshot",
				"overshield",
				"repulsor",
				"threat_sensor",
				"thruster"
		};
	}

	@Override
	public TypedFunctionResult[] getConstructorParameters() {
		return null;
	}

	@Override
	public Class<EquipmentTypeType> getDataType() {
		return EquipmentTypeType.class;
	}

	@Override
	public Class<EquipmentType> getObjectType() {
		return EquipmentType.class;
	}

	@Override
	public SimpleNodeBundle<EquipmentTypeType, CompareEquipmentTypes> equals(EquipmentType other) {
		return new SimpleNodeBundle<>(CompareEquipmentTypes.class,0);
	}

	@Override
	public SimpleNodeBundle<EquipmentTypeType, CompareEquipmentTypes> greaterThan(EquipmentType other) {// not implementable
		return null;
	}

	@Override
	public SimpleNodeBundle<EquipmentTypeType, CompareEquipmentTypes> lessThan(EquipmentType other) {// not implementable
		return null;
	}
}
