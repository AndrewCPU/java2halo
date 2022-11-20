package net.andrewcpu.halo.nodes.nodes.events.inventory.equipment;

import net.andrewcpu.halo.nodes.OutputOnlyNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.EquipmentTypeType;
import net.andrewcpu.halo.type.PlayerType;

public class EquipmentUsedEvent extends OutputOnlyNode {
	public EquipmentUsedEvent() {
		super("Equipment Used Event", new DataType[]{}, new DataType[]{new PlayerType("player"), new EquipmentTypeType("equipmentType")});
	}
}
