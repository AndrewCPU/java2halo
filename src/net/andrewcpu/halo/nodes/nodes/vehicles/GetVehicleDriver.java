package net.andrewcpu.halo.nodes.nodes.vehicles;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;
import net.andrewcpu.halo.type.VehicleType;

public class GetVehicleDriver extends DataNode {
	public GetVehicleDriver() {
		super("Get Vehicle Driver", new DataType[]{new VehicleType("vehicle")}, new DataType[]{new PlayerType("player")});
	}
}
