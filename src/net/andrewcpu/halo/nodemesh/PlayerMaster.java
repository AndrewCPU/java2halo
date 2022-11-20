package net.andrewcpu.halo.nodemesh;

import net.andrewcpu.halo.nodes.nodes.game_mode.player.AdjustPersonalScore;
import net.andrewcpu.halo.nodes.nodes.game_mode.player.AdjustPlayerPoints;
import net.andrewcpu.halo.nodes.nodes.game_mode.player.GetPersonalScore;
import net.andrewcpu.halo.nodes.nodes.game_mode.player.GetPlayerPoints;
import net.andrewcpu.halo.nodes.nodes.inventory.*;
import net.andrewcpu.halo.nodes.nodes.inventory.equipment.*;
import net.andrewcpu.halo.nodes.nodes.players.*;
import net.andrewcpu.halo.nodes.nodes.traits.*;
import net.andrewcpu.halo.nodes.nodes.ui.*;
import net.andrewcpu.halo.nodes.nodes.vehicles.*;
import net.andrewcpu.halo.type.PlayerType;
import net.andrewcpu.halo.type.PlayersType;
import net.andrewcpu.script.highlevel.Player;

import java.util.List;

public class PlayerMaster extends MasterCollection<PlayerType>{
	@Override
	public Class<PlayerType> getDataType() {
		return PlayerType.class;
	}

	public List<PrefillNodeValue> getters() {
		return List.of(
				PrefillNodeValue.of(AreSamePlayer.class, 0, "equals"),
				PrefillNodeValue.of(GetIsAirborne.class, 0, "isAirborne"),
				PrefillNodeValue.of(GetIsCamouflaged.class, 0, "isCamouflaged"),
				PrefillNodeValue.of(GetIsCrouching.class, 0, "isCrouching"),
				PrefillNodeValue.of(GetIsDetected.class, 0, "isDetected"),
				PrefillNodeValue.of(GetIsDetectedByTeam.class, 0, "isDetectedByTeam"),
				PrefillNodeValue.of(GetIsGrappling.class, 0, "isGrappling"),
				PrefillNodeValue.of(GetIsInKnockback.class, 0, "isInKnockback"),
				PrefillNodeValue.of(GetIsLunging.class, 0, "isLunging"),
				PrefillNodeValue.of(GetIsMarkOverridden.class, 0, "isMarkOverridden"),
				PrefillNodeValue.of(GetIsOvershieldOn.class, 0, "isOvershieldOn"),
				PrefillNodeValue.of(GetIsZoomed.class, 0, "isZoomed"),
				PrefillNodeValue.of(GetPlayerAimingVector.class, 0, "getAimingVector"),
				PrefillNodeValue.of(GetPlayerFFAAllegiance.class, 0, "getAllegiance"),
				PrefillNodeValue.of(GetPlayerTeam.class, 0, "getTeam"),
				PrefillNodeValue.of(GetRespawnPenalty.class, 0, "getRespawnPenalty"),
				PrefillNodeValue.of(GetIsBoarding.class, 0, "isBoardingVehicle"),
				PrefillNodeValue.of(GetIsDrivingVehicle.class, 0, "isDrivingVehicle"),
				PrefillNodeValue.of(GetIsGunnerInVehicle.class, 0, "isGunnerInVehicle"),
				PrefillNodeValue.of(GetIsInVehicle.class, 0, "isInVehicle"),
				PrefillNodeValue.of(GetPlayerVehicle.class, 0, "getVehicle"),
				PrefillNodeValue.of(GetIsHoldingSpecificWeapon.class, 0, "isHoldingWeapon"),
				PrefillNodeValue.of(GetIsHoldingWeaponType.class, 0, "isHoldingWeaponType"),
				PrefillNodeValue.of(GetPlayerWeapons.class, 0, "getWeapons"),
				PrefillNodeValue.of(GetIsHoldingAnyEquipment.class, 0, "isHoldingAnyEquipment"),
				PrefillNodeValue.of(GetIsHoldingEquipmentType.class, 0, "isHoldingEquipmentType"),
				PrefillNodeValue.of(GetLoadoutGrenadeCount.class, 0, "getLoadoutGrenadeCount"),
				PrefillNodeValue.of(GetPlayerEquipmentCharges.class, 0, "getEquipmentCharges"),
				PrefillNodeValue.of(GetPlayerGrenadeCount.class, 0, "getGrenadeCount"),
				PrefillNodeValue.of(GetPersonalScore.class, 0, "getPersonalScore"),
				PrefillNodeValue.of(GetPlayerPoints.class, 0, "getPlayerPoints")

		);
	}

	public List<PrefillNodeValue> setters() {
		return List.of(
				PrefillNodeValue.of(SetPlayerCamo.class, 0, "setCamo"),
				PrefillNodeValue.of(SetPlayerFFAAllegiance.class, 0, "setAllegiance"),
				PrefillNodeValue.of(SetPlayerMarkOverride.class, 0, "setMarkOverride"),
				PrefillNodeValue.of(SetPlayerTeam.class, 0, "setTeam"),
				PrefillNodeValue.of(SetRespawnPenalty.class, 0, "setRespawnPenalty"),
				PrefillNodeValue.of(SetObjectiveBannerForPlayer.class, 0, "setObjectiveBanner"),
				PrefillNodeValue.of(SetPlayerWeaponLowered.class, 0, "setWeaponLowered"),
				PrefillNodeValue.of(SetPlayerEquipmentCharges.class, 0, "setEquipmentCharges")
		);
	}

	public List<PrefillNodeValue> functions() {
		return List.of(
				PrefillNodeValue.of(BlockPlayerRespawns.class, 0, "blockRespawns"),
				PrefillNodeValue.of(UnblockRespawnsForPlayer.class, 0, "unblockRespawns"),
				PrefillNodeValue.of(TeleportPlayer.class, 0, "teleport"),
				PrefillNodeValue.of(ApplyTraitSet.class, 1, "applyTraitSet"),
				PrefillNodeValue.of(RemoveTraitSet.class, 1, "removeTraitSet"),
				PrefillNodeValue.of(RemoveAllTraitSets.class, 0, "removeAllTraitSet"),
				PrefillNodeValue.of(ApplyTraitSetForSeconds.class, 1, "applyTraitSetForSeconds"),
				PrefillNodeValue.of(ApplyTraitSetUntilDeath.class, 1, "applyTraitSetUntilDeath"),
				PrefillNodeValue.of(ClearSplashForPlayer.class, 0, "clearSplash"),
				PrefillNodeValue.of(CreateUIMessage.class, 3, "createUIMessage"),
				PrefillNodeValue.of(CreateUIMessageB.class, 3, "createUIMessageB"),
				PrefillNodeValue.of(PushSplashToPlayer.class, 0, "pushSplash"),
				PrefillNodeValue.of(AddPlayerAmmoEquipped.class, 0, "refillEquippedAmmoByPercentage"),
				PrefillNodeValue.of(AddPlayerAmmoUnequipped.class, 0, "refillUnequippedAmmoByPercentage"),
				PrefillNodeValue.of(DropSpecificWeapon.class, 0, "dropWeapon"),
				PrefillNodeValue.of(DropWeaponOfType.class, 0, "dropWeaponType"),
				PrefillNodeValue.of(EmptyPlayerAmmo.class, 0, "emptyAmmo"),
				PrefillNodeValue.of(GivePlayerNewWeapon.class, 0, "giveWeaponType"),
				PrefillNodeValue.of(GivePlayerSpecificWeapon.class, 0, "giveWeapon"),
				PrefillNodeValue.of(RefillPlayerAmmo.class, 0, "refillAmmo"),
				PrefillNodeValue.of(SwitchToFirstWeaponOfType.class, 0, "switchToWeaponType"),
				PrefillNodeValue.of(AdjustPlayerEquipmentCharges.class, 0, "adjustEquipmentCharges"),
				PrefillNodeValue.of(AdjustPlayerGrenades.class, 0, "adjustGrenades"),
				PrefillNodeValue.of(EmptyPlayerEquipment.class, 0, "emptyEquipment"),
				PrefillNodeValue.of(EmptyPlayerGrenades.class, 0, "emptyGrenades"),
				PrefillNodeValue.of(GivePlayerNewEquipment.class, 0, "giveEquipment"),
				PrefillNodeValue.of(RefillDefaultGrenades.class, 0, "refillGrenades"),
				PrefillNodeValue.of(AdjustPersonalScore.class, 0, "adjustPersonalScore"),
				PrefillNodeValue.of(AdjustPlayerPoints.class, 0, "adjustPoints"),
				PrefillNodeValue.of(PrintPlayerToKillfeed.class, 0, "print")
		);
	}
}
