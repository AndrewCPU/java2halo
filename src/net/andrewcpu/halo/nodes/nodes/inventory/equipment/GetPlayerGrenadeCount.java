package net.andrewcpu.halo.nodes.nodes.inventory.equipment;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.GrenadeTypeType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.PlayerType;

public class GetPlayerGrenadeCount extends DataNode {
	public GetPlayerGrenadeCount() {
		super("Get Player Grenade Count", new DataType[]{new PlayerType("player"), new GrenadeTypeType("grenadeType")}, new DataType[]{new NumberType("count")});
	}
}
