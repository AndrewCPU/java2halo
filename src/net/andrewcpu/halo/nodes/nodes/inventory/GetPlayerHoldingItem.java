package net.andrewcpu.halo.nodes.nodes.inventory;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectType;
import net.andrewcpu.halo.type.PlayerType;

public class GetPlayerHoldingItem extends DataNode {
	public GetPlayerHoldingItem() {
		super("Get Player Holding Item", new DataType[]{new ObjectType("object")}, new DataType[]{new PlayerType("player")});
	}
}
