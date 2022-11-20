package net.andrewcpu.script.highlevel.types;

import net.andrewcpu.halo.nodes.nodes.inventory.*;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.WeaponType;
import net.andrewcpu.halo.type.WeaponTypeType;
import net.andrewcpu.script.highlevel.ComplexNodeBundle;
import net.andrewcpu.script.highlevel.HighLevelObject;
import net.andrewcpu.script.highlevel.SimpleNodeBundle;
import net.andrewcpu.script.highlevel.TypedFunctionResult;

public class Weapon extends HighLevelObject<WeaponType> {
	public Weapon() {
		super(false);
	}

	@Override
	public TypedFunctionResult[] getConstructorParameters() {
		return null;
	}

	@Override
	public Class<WeaponType> getDataType() {
		return WeaponType.class;
	}

	public SimpleNodeBundle<NumberType, GetWeaponMagazineCapacity> getMagazineCapacity() {
		return new SimpleNodeBundle<>(GetWeaponMagazineCapacity.class, 0);
	}

	public SimpleNodeBundle<NumberType, GetWeaponMagazineRounds> getMagazineRounds() {
		return new SimpleNodeBundle<>(GetWeaponMagazineRounds.class, 0);
	}

	public ComplexNodeBundle<GetWeaponType> getWeaponType() {
		return new ComplexNodeBundle<>(GetWeaponType.class, 0);
	}

	public ComplexNodeBundle<AreSameWeaponType> areSameWeaponType(Weapon weapon) {
		return new ComplexNodeBundle<>(AreSameWeaponType.class, 0);
	}

	public SimpleNodeBundle<BooleanType, GetIsWeaponType> isType(net.andrewcpu.script.highlevel.types.WeaponType weaponType) {
		return new SimpleNodeBundle<>(GetIsWeaponType.class, 0);
	}

}
