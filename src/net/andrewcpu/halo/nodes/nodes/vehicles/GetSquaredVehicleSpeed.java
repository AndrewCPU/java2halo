package net.andrewcpu.halo.nodes.nodes.vehicles;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.PlayerType;

public class GetSquaredVehicleSpeed extends DataNode {
	public GetSquaredVehicleSpeed() {
		super("Get Squared Vehicle Speed", new DataType[]{new PlayerType("player")}, new DataType[]{new NumberType("speed")});
	}
}
