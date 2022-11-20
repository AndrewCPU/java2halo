package net.andrewcpu.halo.nodes.nodes.inventory.equipment;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.EquipmentType;

public class AreSameEquipmentType extends DataNode {
	public AreSameEquipmentType() {
		super("Are Same Equipment Type", new DataType[]{new EquipmentType("a"), new EquipmentType("b")}, new DataType[]{new BooleanType("isSame")});
	}
}
