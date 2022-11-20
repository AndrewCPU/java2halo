package net.andrewcpu.halo.nodes.nodes.inventory.equipment;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.EquipmentTypeType;
import net.andrewcpu.halo.type.PlayerType;

public class GetIsHoldingEquipmentType extends DataNode {
	public GetIsHoldingEquipmentType() {
		super("Get is Holding Equipment Type", new DataType[]{new PlayerType("player"), new EquipmentTypeType("equipmentType")}, new DataType[]{new BooleanType("isHolding")});
	}
}
