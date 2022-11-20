package net.andrewcpu.halo.nodes.nodes.inventory.equipment;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;

public class EmptyPlayerEquipment extends IONode {
	public EmptyPlayerEquipment() {
		super("Empty Player Equipment", new DataType[]{new PlayerType("player")}, new DataType[]{});
	}
}
