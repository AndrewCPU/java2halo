package net.andrewcpu.halo.nodemesh;

import java.util.List;

public class AllMasterCollections {
	public static List<MasterCollection> getAllCollections() {
		List<MasterCollection> collections = List.of(new EquipmentMaster(), new ObjectListMaster(), new ObjectMaster(), new PlayerListMaster(), new PlayerMaster(), new TeamMaster(), new VectorMaster(), new VehicleMaster(), new WeaponMaster());
		return  collections;
	}

	public static MasterCollection getMasterOfType(Class className) {
		List<MasterCollection> collections = getAllCollections();
		for(MasterCollection collection : collections){
			if(collection.getDataType() == className){
				return collection;
			}
		}
		return null;
	}
}
