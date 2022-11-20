package net.andrewcpu.halo.nodemesh;

import net.andrewcpu.halo.type.DataType;

import java.util.List;

public abstract class MasterCollection<T extends DataType> {
	public abstract Class<T> getDataType();
	public abstract List<PrefillNodeValue> getters();
	public abstract List<PrefillNodeValue> setters();
	public abstract List<PrefillNodeValue> functions();

}
