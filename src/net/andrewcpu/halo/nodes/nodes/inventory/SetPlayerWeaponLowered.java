package net.andrewcpu.halo.nodes.nodes.inventory;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;

public class SetPlayerWeaponLowered extends IONode {
	public SetPlayerWeaponLowered() {
		super("Set Player Weapon Lowered", new DataType[]{new PlayerType("player"), new BooleanType("lowered")}, new DataType[]{});
	}
}
