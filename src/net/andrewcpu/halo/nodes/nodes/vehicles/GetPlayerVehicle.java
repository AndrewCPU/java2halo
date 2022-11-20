package net.andrewcpu.halo.nodes.nodes.vehicles;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;
import net.andrewcpu.halo.type.VehicleType;

public class GetPlayerVehicle extends DataNode {
	public GetPlayerVehicle() {
		super("Get Player Vehicle", new DataType[]{new PlayerType("player")}, new DataType[]{new VehicleType("vehicle")});
	}
}
