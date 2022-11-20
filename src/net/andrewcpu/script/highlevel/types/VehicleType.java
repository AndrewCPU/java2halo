package net.andrewcpu.script.highlevel.types;

import net.andrewcpu.halo.nodes.nodes.logic.CompareVehicleTypes;
import net.andrewcpu.halo.type.VehicleTypeType;
import net.andrewcpu.script.highlevel.HighLevelObject;
import net.andrewcpu.script.highlevel.SimpleNodeBundle;
import net.andrewcpu.script.highlevel.TypedFunctionResult;
import net.andrewcpu.script.highlevel.interfaces.HaloComparable;
import net.andrewcpu.script.highlevel.interfaces.HaloConstant;

public class VehicleType extends HighLevelObject<VehicleTypeType> implements HaloConstant<VehicleTypeType, VehicleType>, HaloComparable<VehicleTypeType, VehicleType, CompareVehicleTypes> {
	public VehicleType() {
		super(false);
	}

	@Override
	public java.lang.String[] getConstants() {
		return new java.lang.String[]{
				"banshee",
				"brute_chopper",
				"chopper_boss",
				"ghost",
				"gungoose",
				"mongoose",
				"razorback",
				"rocket_hog",
				"scorpion",
				"warthog",
				"wasp",
				"wraith"
		};
	}

	@Override
	public Class<VehicleTypeType> getDataType() {
		return VehicleTypeType.class;
	}

	@Override
	public Class<VehicleType> getObjectType() {
		return VehicleType.class;
	}

	@Override
	public SimpleNodeBundle<VehicleTypeType, CompareVehicleTypes> equals(VehicleType other) {
		return new SimpleNodeBundle<>(CompareVehicleTypes.class,0);
	}

	@Override
	public SimpleNodeBundle<VehicleTypeType, CompareVehicleTypes> greaterThan(VehicleType other) {
		return null;
	}

	@Override
	public SimpleNodeBundle<VehicleTypeType, CompareVehicleTypes> lessThan(VehicleType other) {
		return null;
	}
}
