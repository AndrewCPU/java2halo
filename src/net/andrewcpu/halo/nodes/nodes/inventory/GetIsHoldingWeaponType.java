package net.andrewcpu.halo.nodes.nodes.inventory;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.*;

public class GetIsHoldingWeaponType extends DataNode {
	public GetIsHoldingWeaponType() {
		super("Get is Holding Weapon Type", new DataType[]{new PlayerType("player"), new WeaponTypeType("weaponType")}, new DataType[]{new BooleanType("isHolding")});
	}
}
