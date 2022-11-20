package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.EquipmentTypeType;

public class GetEquipmentTypeVariable extends ISONode<EquipmentTypeType> {
	public GetEquipmentTypeVariable() {
		super("Get Equipment Type Variable", new EquipmentTypeType("value"));
	}
}
