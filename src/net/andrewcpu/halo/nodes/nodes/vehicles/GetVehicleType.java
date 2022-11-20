package net.andrewcpu.halo.nodes.nodes.vehicles;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.*;

public class GetVehicleType extends DataNode {
	public GetVehicleType() {
		super("Get Vehicle Type", new DataType[]{new VehicleType("vehicle")}, new DataType[]{new VehicleTypeType("vehicleType")});
	}
}
