package net.andrewcpu.halo.nodes.nodes.players;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;

public class GetIsZoomed extends DataNode {
	public GetIsZoomed(){
		super("Get is Zoomed", new DataType[]{new PlayerType("player")}, new DataType[]{new BooleanType("isZoomed")});
	}
}
