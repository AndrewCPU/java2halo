package net.andrewcpu.halo.nodes.nodes.events.inventory.equipment;

import net.andrewcpu.halo.nodes.OutputOnlyNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.EquipmentTypeType;
import net.andrewcpu.halo.type.PlayerType;
import net.andrewcpu.halo.type.VectorType;

public class EquipmentPickupEvent extends OutputOnlyNode {
	public EquipmentPickupEvent() {
		super("Equipment Pickup Event", new DataType[]{}, new DataType[]{new PlayerType("player"), new EquipmentTypeType("equipmentType"), new VectorType("position")});
	}
}
