package net.andrewcpu.halo.nodes.nodes.inventory.equipment;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.EquipmentTypeType;
import net.andrewcpu.halo.type.PlayerType;

public class GetIsHoldingAnyEquipment extends DataNode {
	public GetIsHoldingAnyEquipment() {
		super("Get is Holding Any Equipment", new DataType[]{new PlayerType("player")}, new DataType[]{new BooleanType("anyEquipment"), new BooleanType("isPowerup"), new EquipmentTypeType("equipmentType")});
	}
}
