package net.andrewcpu.script.highlevel.types;

import net.andrewcpu.halo.type.IdentifierType;
import net.andrewcpu.halo.type.StringType;
import net.andrewcpu.script.highlevel.HighLevelObject;
import net.andrewcpu.script.highlevel.TypedFunctionResult;

public class Identifier extends HighLevelObject<IdentifierType> {
	public Identifier() {
		super(true);
	}

	@Override
	public TypedFunctionResult[] getConstructorParameters() {
		return new TypedFunctionResult[]{new TypedFunctionResult(new StringType("identifier"), "identifier")};
	}

	@Override
	public Class<IdentifierType> getDataType() {
		return IdentifierType.class;
	}
}
