package net.andrewcpu.halo.nodes.nodes.vehicles;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.VehicleType;

public class GetIsOverturned extends DataNode {
	public GetIsOverturned() {
		super("Get is Overturned", new DataType[]{new VehicleType("vehicle")}, new DataType[]{new BooleanType("isOverturned")});
	}
}
