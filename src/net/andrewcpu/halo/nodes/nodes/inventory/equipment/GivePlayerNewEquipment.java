package net.andrewcpu.halo.nodes.nodes.inventory.equipment;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.EquipmentTypeType;
import net.andrewcpu.halo.type.PlayerType;

public class GivePlayerNewEquipment extends IONode {
	public GivePlayerNewEquipment() {
		super("Give Player New Equipment", new DataType[]{new PlayerType("player"), new EquipmentTypeType("equipmentType")}, new DataType[]{});
	}
}
