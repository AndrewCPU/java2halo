package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.VehicleTypeType;

public class SetVehicleTypeVariable extends IVSONode<VehicleTypeType>{
	public SetVehicleTypeVariable() {
		super("Set Vehicle Type Variable.json", new VehicleTypeType("value"));
	}
}
