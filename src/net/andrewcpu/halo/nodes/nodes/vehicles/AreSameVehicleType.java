package net.andrewcpu.halo.nodes.nodes.vehicles;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.VehicleType;

public class AreSameVehicleType extends DataNode {
	public AreSameVehicleType() { // are same base typ, are same vehicle typ
		super("Are Same Vehicle Type", new DataType[]{new VehicleType("a"), new VehicleType("b")}, new DataType[]{new BooleanType("base"), new BooleanType("same")});
	}
}
