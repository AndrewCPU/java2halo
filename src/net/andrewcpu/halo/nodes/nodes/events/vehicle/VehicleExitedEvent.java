package net.andrewcpu.halo.nodes.nodes.events.vehicle;

import net.andrewcpu.halo.nodes.OutputOnlyNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;
import net.andrewcpu.halo.type.VehicleType;

public class VehicleExitedEvent extends OutputOnlyNode {
	public VehicleExitedEvent() {
		super("Vehicle Exited Event", new DataType[]{}, new DataType[]{new PlayerType("player"), new VehicleType("vehicle")});
	}
}
