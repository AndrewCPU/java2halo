package net.andrewcpu.halo.nodes.nodes.logic;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.VehicleTypeType;

public class CompareVehicleTypes extends DataNode {
	public CompareVehicleTypes() {
		super("Compare Vehicle Types", new DataType[]{new VehicleTypeType("a"), new VehicleTypeType("b")}, new DataType[]{new BooleanType("equal")});
	}
}
