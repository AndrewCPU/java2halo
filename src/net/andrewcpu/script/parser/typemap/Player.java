package net.andrewcpu.script.parser.typemap;

import net.andrewcpu.halo.type.*;
import net.andrewcpu.script.parser.typemap.util.MultiResponseType;
import net.andrewcpu.script.parser.typemap.util.NamedResult;
import net.andrewcpu.script.parser.typemap.util.TypeItem;

public abstract class Player extends TypeItem {
	public abstract ExecutionThreadType blockRespawns(RespawnMessageType respawnMessage);
	public abstract ExecutionThreadType unblockRespawns();
	public abstract ExecutionThreadType teleport(VectorType position, BooleanType withVehicle);
	public abstract ExecutionThreadType applyTraitSet(IdentifierType identifier, BooleanType immediate);
	public abstract ExecutionThreadType removeTraitSet(IdentifierType identifier, BooleanType immediate);
	public abstract ExecutionThreadType removeAllTraitSet(BooleanType immediate);
	public abstract ExecutionThreadType applyTraitSetForSeconds(IdentifierType identifier, NumberType seconds);
	public abstract ExecutionThreadType applyTraitSetUntilDeath(IdentifierType identifier);
	public abstract ExecutionThreadType clearSplash();
	public abstract UIMessageType createUIMessage(UIMessageTemplateType messageTemplate, StringType string1, StringType string2);
	public abstract UIMessageType createUIMessageB(UIMessageTemplateType messageTemplate, StringType string1, StringType string2);
	public abstract ExecutionThreadType pushSplash(NumberType seconds, UIMessageType message);
	public abstract ExecutionThreadType refillEquippedAmmoByPercentage(NumberType refillPercent);
	public abstract ExecutionThreadType refillUnequippedAmmoByPercentage(NumberType refillPercent);
	public abstract ExecutionThreadType dropWeapon(WeaponType weapon);
	public abstract ExecutionThreadType dropWeaponType(WeaponTypeType weaponType);
	public abstract ExecutionThreadType emptyAmmo();
	public abstract ExecutionThreadType giveWeaponType(WeaponTypeType weaponType, WeaponAdditionMethodType additionMethod, BooleanType waitUntilComplete);
	public abstract ExecutionThreadType giveWeapon(WeaponType weapon, WeaponAdditionMethodType additionMethod, BooleanType waitUntilComplete);
	public abstract ExecutionThreadType refillAmmo();
	public abstract ExecutionThreadType switchToWeaponType(WeaponTypeType weaponType);
	public abstract ExecutionThreadType adjustEquipmentCharges(NumberType adjustment);
	public abstract ExecutionThreadType adjustGrenades(GrenadeTypeType grenadeType, NumberType adjustment);
	public abstract ExecutionThreadType emptyEquipment();
	public abstract ExecutionThreadType emptyGrenades();
	public abstract ExecutionThreadType giveEquipment(EquipmentTypeType equipmentType);
	public abstract ExecutionThreadType refillGrenades();
	public abstract ExecutionThreadType adjustPersonalScore(NumberType adjustment);
	public abstract ExecutionThreadType adjustPoints(NumberType adjustment);
	public abstract ExecutionThreadType print();
	public abstract BooleanType equals(PlayerType b);
	public abstract BooleanType isAirborne();
	public abstract BooleanType isCamouflaged();
	public abstract BooleanType isCrouching();
	public abstract BooleanType isDetected();
	public abstract BooleanType isDetectedByTeam(TeamType team);
	public abstract BooleanType isGrappling();
	public abstract BooleanType isInKnockback();
	public abstract BooleanType isLunging();
	public abstract BooleanType isMarkOverridden();
	public abstract BooleanType isOvershieldOn();
	public abstract BooleanType isZoomed();
	public abstract VectorType getAimingVector();
	public abstract TeamType getAllegiance();
	public abstract TeamType getTeam();
	public abstract NumberType getRespawnPenalty();
	public abstract BooleanType isBoardingVehicle();
	public abstract BooleanType isDrivingVehicle();
	public abstract BooleanType isGunnerInVehicle();
	public abstract BooleanType isInVehicle();
	public abstract VehicleType getVehicle();
	public abstract BooleanType isHoldingWeapon(WeaponType weapon);
	public abstract BooleanType isHoldingWeaponType(WeaponTypeType weaponType);
	public abstract WeaponType getEquippedWeapon();
	public abstract WeaponType getUnequippedWeapon();
	public abstract BooleanType isHoldingAnyEquipment();
	public abstract BooleanType isHoldingPowerup();
	public abstract BooleanType getHoldingEquipmentType();
	public abstract BooleanType isHoldingEquipmentType(EquipmentTypeType equipmentType);
	public abstract NumberType getLoadoutGrenadeCount(GrenadeTypeType grenadeType);
	public abstract NumberType getEquipmentCharges();
	public abstract NumberType getGrenadeCount(GrenadeTypeType grenadeType);
	public abstract NumberType getTotalPersonalScore();
	public abstract NumberType getRoundPersonalScore();
	public abstract NumberType getTotalPoints();
	public abstract NumberType getRoundPoints();
	public abstract ExecutionThreadType setCamo(NumberType seconds);
	public abstract ExecutionThreadType setAllegiance(TeamType team);
	public abstract ExecutionThreadType setMarkOverride(BooleanType override);
	public abstract ExecutionThreadType setTeam(TeamType team);
	public abstract ExecutionThreadType setRespawnPenalty(NumberType seconds);
	public abstract ExecutionThreadType setObjectiveBanner(BooleanType enabled, UIMessageType message);
	public abstract ExecutionThreadType setWeaponLowered(BooleanType lowered);
	public abstract ExecutionThreadType setEquipmentCharges(NumberType charges);
}
