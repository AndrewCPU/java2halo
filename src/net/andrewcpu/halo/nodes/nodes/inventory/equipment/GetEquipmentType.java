package net.andrewcpu.halo.nodes.nodes.inventory.equipment;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.EquipmentType;
import net.andrewcpu.halo.type.EquipmentTypeType;

public class GetEquipmentType extends DataNode {
	public GetEquipmentType() {
		super("Get Equipment Type", new DataType[]{new EquipmentType("equipment")}, new DataType[]{new EquipmentTypeType("equipmentType"), new BooleanType("isPowerup")});
	}
}
