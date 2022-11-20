package net.andrewcpu.script.highlevel.types;

import net.andrewcpu.halo.nodes.nodes.logic.CompareGrenadeTypes;
import net.andrewcpu.halo.type.GrenadeTypeType;
import net.andrewcpu.script.highlevel.HighLevelObject;
import net.andrewcpu.script.highlevel.SimpleNodeBundle;
import net.andrewcpu.script.highlevel.TypedFunctionResult;
import net.andrewcpu.script.highlevel.interfaces.HaloComparable;
import net.andrewcpu.script.highlevel.interfaces.HaloConstant;

public class GrenadeType extends HighLevelObject<GrenadeTypeType> implements HaloConstant<GrenadeTypeType, GrenadeType>, HaloComparable<GrenadeTypeType, GrenadeType, CompareGrenadeTypes> {
	public GrenadeType() {
		super(false);
	}

	@Override
	public java.lang.String[] getConstants() {
		return new java.lang.String[] {
				"dynamo",
				"fragmentation",
				"plasma",
				"spike"
		};
	}

	@Override
	public TypedFunctionResult[] getConstructorParameters() {
		return null;
	}

	@Override
	public Class<GrenadeTypeType> getDataType() {
		return GrenadeTypeType.class;
	}

	@Override
	public Class<GrenadeType> getObjectType() {
		return GrenadeType.class;
	}

	@Override
	public SimpleNodeBundle<GrenadeTypeType, CompareGrenadeTypes> equals(GrenadeType other) {
		return new SimpleNodeBundle<>(CompareGrenadeTypes.class,0);
	}

	@Override
	public SimpleNodeBundle<GrenadeTypeType, CompareGrenadeTypes> greaterThan(GrenadeType other) {
		return null;
	}

	@Override
	public SimpleNodeBundle<GrenadeTypeType, CompareGrenadeTypes> lessThan(GrenadeType other) {
		return null;
	}
}
