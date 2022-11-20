package net.andrewcpu.script.highlevel.types;

import net.andrewcpu.halo.type.WeaponAdditionMethodType;
import net.andrewcpu.script.highlevel.HighLevelObject;
import net.andrewcpu.script.highlevel.TypedFunctionResult;
import net.andrewcpu.script.highlevel.interfaces.HaloConstant;

public class WeaponAdditionMethod extends HighLevelObject<WeaponAdditionMethodType> implements HaloConstant<WeaponAdditionMethodType, WeaponAdditionMethod> {
	public WeaponAdditionMethod() {
		super(false);
	}

	@Override
	public java.lang.String[] getConstants() {
		return new java.lang.String[]{
				"default",
				"if_room",
				"replace_all",
				"swap_primary",
				"swap_secondary"
		};
	}


	@Override
	public Class<WeaponAdditionMethodType> getDataType() {
		return WeaponAdditionMethodType.class;
	}

	@Override
	public Class<WeaponAdditionMethod> getObjectType() {
		return WeaponAdditionMethod.class;
	}
}
