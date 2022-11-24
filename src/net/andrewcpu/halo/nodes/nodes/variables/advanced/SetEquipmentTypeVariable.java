package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.EquipmentTypeType;

public class SetEquipmentTypeVariable extends IVSONode<EquipmentTypeType>{
	public SetEquipmentTypeVariable() {
		super("Set Equipment Type Variable.json", new EquipmentTypeType("value"));
	}
}
