package net.andrewcpu.halo.nodes.nodes.players;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;

public class GetIsAirborne extends DataNode {
	public GetIsAirborne() {
		super("Get is Airborne", new DataType[]{new PlayerType("player")}, new DataType[]{new BooleanType("isAirborne")});
	}
}
