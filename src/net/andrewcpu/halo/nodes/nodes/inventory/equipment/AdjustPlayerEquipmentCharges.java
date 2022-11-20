package net.andrewcpu.halo.nodes.nodes.inventory.equipment;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.PlayerType;

public class AdjustPlayerEquipmentCharges extends IONode {
	public AdjustPlayerEquipmentCharges() {
		super("Adjust Player Equipment Charges", new DataType[]{new PlayerType("player"), new NumberType("adjustment")}, new DataType[]{});
	}
}
