package net.andrewcpu.script.highlevel;

import net.andrewcpu.halo.type.DataType;

public abstract class HighLevelObject<T extends DataType> {
	private boolean canBeConstructed;
	public HighLevelObject(boolean canBeConstructed) {
		this.canBeConstructed = canBeConstructed;
	}

	public TypedFunctionResult[] getConstructorParameters() {
		return null;
	}

	public abstract Class<T> getDataType();
}
