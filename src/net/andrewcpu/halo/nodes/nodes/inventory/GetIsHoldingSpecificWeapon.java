package net.andrewcpu.halo.nodes.nodes.inventory;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;
import net.andrewcpu.halo.type.WeaponType;

public class GetIsHoldingSpecificWeapon extends DataNode {
	public GetIsHoldingSpecificWeapon() {
		super("Get is Holding Specific Weapon", new DataType[]{new PlayerType("player"), new WeaponType("weapon")}, new DataType[]{new BooleanType("isHolding")});
	}
}
