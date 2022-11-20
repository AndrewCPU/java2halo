package net.andrewcpu.halo.nodes.nodes.inventory.equipment;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.PlayerType;

public class SetPlayerEquipmentCharges extends IONode {
	public SetPlayerEquipmentCharges() {
		super("Set Player Equipment Charges", new DataType[]{new PlayerType("player"), new NumberType("charges")}, new DataType[]{});
	}
}
