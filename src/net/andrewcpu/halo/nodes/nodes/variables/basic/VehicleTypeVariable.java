package net.andrewcpu.halo.nodes.nodes.variables.basic;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.VehicleTypeType;

public class VehicleTypeVariable extends DataNode {
	public VehicleTypeVariable() {
		super("Vehicle Type Variable", new DataType[]{new VehicleTypeType("value")}, new DataType[]{new VehicleTypeType("value")});
	}
}
