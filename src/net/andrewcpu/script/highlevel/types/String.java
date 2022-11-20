package net.andrewcpu.script.highlevel.types;

import net.andrewcpu.halo.type.StringType;
import net.andrewcpu.script.highlevel.HighLevelObject;

public class String extends HighLevelObject<StringType> {
	public String() {
		super(false);
	}

	@Override
	public Class<StringType> getDataType() {
		return StringType.class;
	}
}
