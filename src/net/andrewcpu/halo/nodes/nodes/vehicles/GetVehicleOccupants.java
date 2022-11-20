package net.andrewcpu.halo.nodes.nodes.vehicles;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.*;

public class GetVehicleOccupants extends DataNode {
	public GetVehicleOccupants() {
		super("Get Vehicle Occupants", new DataType[]{new VehicleType("vehicle")}, new DataType[]{new PlayersType("players")});
	}
}
