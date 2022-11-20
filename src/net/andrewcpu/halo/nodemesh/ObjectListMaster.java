package net.andrewcpu.halo.nodemesh;

import net.andrewcpu.halo.nodes.nodes.logic.ForEachObject;
import net.andrewcpu.halo.nodes.nodes.objects.*;
import net.andrewcpu.halo.type.ObjectsType;

import java.util.List;

public class ObjectListMaster extends MasterCollection<ObjectsType> {
	@Override
	public Class<ObjectsType> getDataType() {
		return ObjectsType.class;
	}

	@Override
	public List<PrefillNodeValue> getters() {
		return List.of(
				PrefillNodeValue.of(GetListSize.class, 0, "getSize"),
					PrefillNodeValue.of(GetObjectAtIndex.class, 0, "atIndex"),
				PrefillNodeValue.of(GetSharedObjects.class,0 ,"getSharedObjects"),
				PrefillNodeValue.of(GetUniqueObjects.class,0 ,"getUniqueObjects"),
				PrefillNodeValue.of(ObjectIsInList.class, 0, "contains"),
				PrefillNodeValue.of(ForEachObject.class, 0, "forEach")
		);
	}

	@Override
	public List<PrefillNodeValue> setters() {
		return List.of();
	}

	@Override
	public List<PrefillNodeValue> functions() {
		return List.of(
				PrefillNodeValue.of(AddObjectToList.class, 0, "add"), // todo this will need a dynamic reallocation of the list node reference
				PrefillNodeValue.of(RemoveObjectFromList.class, 0, "remove"), // todo ^^
				PrefillNodeValue.of(CombineObjectLists.class, 0, "combine")
		);
	}
}
