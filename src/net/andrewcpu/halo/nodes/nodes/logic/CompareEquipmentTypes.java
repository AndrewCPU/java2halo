package net.andrewcpu.halo.nodes.nodes.logic;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.EquipmentTypeType;

public class CompareEquipmentTypes extends DataNode {
	public CompareEquipmentTypes() {
		super("Compare Equipment Types", new DataType[]{new EquipmentTypeType("a"), new EquipmentTypeType("b")}, new DataType[]{new BooleanType("equal")});
	}
}
