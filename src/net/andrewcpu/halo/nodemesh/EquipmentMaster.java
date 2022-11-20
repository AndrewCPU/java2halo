package net.andrewcpu.halo.nodemesh;

import net.andrewcpu.halo.nodes.nodes.inventory.equipment.AreSameEquipmentType;
import net.andrewcpu.halo.nodes.nodes.inventory.equipment.GetEquipmentType;
import net.andrewcpu.halo.type.EquipmentType;

import java.util.List;

public class EquipmentMaster extends MasterCollection<EquipmentType> {
	@Override
	public Class<EquipmentType> getDataType() {
		return EquipmentType.class;
	}

	@Override
	public List<PrefillNodeValue> getters() {
		return List.of(
				PrefillNodeValue.of(AreSameEquipmentType.class, 0, "equal"),
				PrefillNodeValue.of(GetEquipmentType.class, 0,"getType")
		);
	}

	@Override
	public List<PrefillNodeValue> setters() {
		return List.of(

		);
	}

	@Override
	public List<PrefillNodeValue> functions() {
		return List.of(

		);
	}
}
