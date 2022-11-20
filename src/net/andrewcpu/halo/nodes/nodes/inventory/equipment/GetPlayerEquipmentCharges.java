package net.andrewcpu.halo.nodes.nodes.inventory.equipment;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.PlayerType;

public class GetPlayerEquipmentCharges extends DataNode {
	public GetPlayerEquipmentCharges() {
		super("Get Player Equipment Charges", new DataType[]{new PlayerType("player")}, new DataType[]{new NumberType("charges")});
	}
}
