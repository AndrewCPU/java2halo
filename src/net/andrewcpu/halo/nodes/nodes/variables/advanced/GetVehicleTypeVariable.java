package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.VehicleTypeType;

public class GetVehicleTypeVariable extends ISONode<VehicleTypeType> {
	public GetVehicleTypeVariable() {
		super("Get Vehicle Type Variable", new VehicleTypeType("value"));
	}
}
