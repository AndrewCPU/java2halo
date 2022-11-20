package net.andrewcpu.halo.nodes.nodes.variables.basic;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.EquipmentTypeType;

public class EquipmentTypeVariable extends DataNode {
	public EquipmentTypeVariable(){
		super("Equipment Type Variable", new DataType[]{new EquipmentTypeType("value")}, new DataType[]{new EquipmentTypeType("value")});
	}
}
