package net.andrewcpu.script.highlevel.types;

import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.script.highlevel.HighLevelObject;
import net.andrewcpu.script.highlevel.TypedFunctionResult;

public class Boolean extends HighLevelObject<BooleanType> {

	public Boolean() {
		super(false);
	}

	@Override
	public TypedFunctionResult[] getConstructorParameters() {
		return null;
	}

	@Override
	public Class<BooleanType> getDataType() {
		return BooleanType.class;
	}
}
