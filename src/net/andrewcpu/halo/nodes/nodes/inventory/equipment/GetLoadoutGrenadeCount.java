package net.andrewcpu.halo.nodes.nodes.inventory.equipment;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.GrenadeTypeType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.PlayerType;

public class GetLoadoutGrenadeCount extends DataNode {
	public GetLoadoutGrenadeCount() {
		super("Get Loadout Grenade Count", new DataType[]{new PlayerType("player"), new GrenadeTypeType("grenadeType")}, new DataType[]{new NumberType("count")});
	}
}
