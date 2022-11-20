package net.andrewcpu.halo.nodes.nodes.vehicles;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;

public class GetIsDrivingVehicle extends DataNode {
	public GetIsDrivingVehicle() {
		super("Get is Driving Vehicle", new DataType[]{new PlayerType("player")}, new DataType[]{new BooleanType("isDriving")});
	}
}
