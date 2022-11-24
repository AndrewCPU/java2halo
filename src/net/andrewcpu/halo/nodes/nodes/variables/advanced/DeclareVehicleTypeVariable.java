package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.VehicleTypeType;

public class DeclareVehicleTypeVariable extends IISNode<VehicleTypeType> {
	public DeclareVehicleTypeVariable() {
		super("Declare Vehicle Type Variable.json ", new VehicleTypeType("initialValue"));
	}
}
