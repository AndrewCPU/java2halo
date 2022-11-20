package net.andrewcpu.halo.nodemesh;

import net.andrewcpu.halo.nodes.nodes.vehicles.*;
import net.andrewcpu.halo.type.VehicleType;

import java.util.List;

public class VehicleMaster extends MasterCollection<VehicleType> {
	@Override
	public Class<VehicleType> getDataType() {
		return VehicleType.class;
	}

	@Override
	public List<PrefillNodeValue> getters() {
		return List.of(
				PrefillNodeValue.of(AreSameVehicleType.class, 0, "equal"),
				PrefillNodeValue.of(GetIsOverturned.class, 0, "isOverturned"),
				PrefillNodeValue.of(GetSquaredVehicleSpeed.class, 0, "getSpeed"),
				PrefillNodeValue.of(GetVehicleDriver.class, 0, "getDriver"),
				PrefillNodeValue.of(GetVehicleEnterableByPlayer.class, 0, "isEnterable"),
				PrefillNodeValue.of(GetVehicleGunner.class, 0, "getGunner"),
				PrefillNodeValue.of(GetVehicleOccupants.class, 0, "getOccupants"),
				PrefillNodeValue.of(GetVehicleType.class, 0, "getType")
		);
	}

	@Override
	public List<PrefillNodeValue> setters() {
		return List.of();
	}

	@Override
	public List<PrefillNodeValue> functions() {
		return List.of(
		);
	}
}
