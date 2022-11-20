package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.EquipmentTypeType;

public class DeclareEquipmentTypeVariable extends IISNode<EquipmentTypeType> {
	public DeclareEquipmentTypeVariable() {
		super("Declare Equipment Type Variable ", new EquipmentTypeType("initialValue"));
	}
}
