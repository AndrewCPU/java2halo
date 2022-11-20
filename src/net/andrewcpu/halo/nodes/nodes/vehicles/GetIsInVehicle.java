package net.andrewcpu.halo.nodes.nodes.vehicles;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;

public class GetIsInVehicle extends DataNode {
	public GetIsInVehicle() {
		super("Get is in Vehicle", new DataType[]{new PlayerType("player")}, new DataType[]{new BooleanType("isInVehicle")});
	}
}
