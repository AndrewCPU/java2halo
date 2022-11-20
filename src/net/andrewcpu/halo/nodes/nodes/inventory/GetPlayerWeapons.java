package net.andrewcpu.halo.nodes.nodes.inventory;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;
import net.andrewcpu.halo.type.WeaponType;

public class GetPlayerWeapons extends DataNode {
	public GetPlayerWeapons() {
		super("Get Player Weapons", new DataType[]{new PlayerType("player")}, new DataType[]{new WeaponType("equipped"), new WeaponType("unequipped")});
	}
}
