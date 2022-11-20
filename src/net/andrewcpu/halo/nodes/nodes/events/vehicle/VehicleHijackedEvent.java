package net.andrewcpu.halo.nodes.nodes.events.vehicle;

import net.andrewcpu.halo.nodes.OutputOnlyNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;
import net.andrewcpu.halo.type.VehicleType;

public class VehicleHijackedEvent extends OutputOnlyNode {
	public VehicleHijackedEvent() {
		super("Vehicle Hijacked Event", new DataType[]{}, new DataType[]{new PlayerType("player"), new VehicleType("vehicle")});
	}
}
