package net.andrewcpu.halo.nodes;

import net.andrewcpu.halo.nodes.nodes.audio.*;
import net.andrewcpu.halo.nodes.nodes.bots.*;
import net.andrewcpu.halo.nodes.nodes.events.custom.EveryNSecondsEvent;
import net.andrewcpu.halo.nodes.nodes.events.game.GameStartEvent;
import net.andrewcpu.halo.nodes.nodes.events.game.GameplayStartEvent;
import net.andrewcpu.halo.nodes.nodes.events.game.RoundEndEvent;
import net.andrewcpu.halo.nodes.nodes.events.game.RoundStartEvent;
import net.andrewcpu.halo.nodes.nodes.events.inventory.equipment.EquipmentPickupEvent;
import net.andrewcpu.halo.nodes.nodes.events.inventory.equipment.EquipmentUsedEvent;
import net.andrewcpu.halo.nodes.nodes.events.inventory.weapons.*;
import net.andrewcpu.halo.nodes.nodes.events.object.*;
import net.andrewcpu.halo.nodes.nodes.events.player.*;
import net.andrewcpu.halo.nodes.nodes.events.vehicle.VehicleEnteredEvent;
import net.andrewcpu.halo.nodes.nodes.events.vehicle.VehicleExitedEvent;
import net.andrewcpu.halo.nodes.nodes.events.vehicle.VehicleHijackedEvent;
import net.andrewcpu.halo.nodes.nodes.events.vehicle.VehicleOverturnedEvent;
import net.andrewcpu.halo.nodes.nodes.game_mode.game.*;
import net.andrewcpu.halo.nodes.nodes.game_mode.player.AdjustPersonalScore;
import net.andrewcpu.halo.nodes.nodes.game_mode.player.AdjustPlayerPoints;
import net.andrewcpu.halo.nodes.nodes.game_mode.player.GetPersonalScore;
import net.andrewcpu.halo.nodes.nodes.game_mode.player.GetPlayerPoints;
import net.andrewcpu.halo.nodes.nodes.game_mode.team.AdjustTeamPoints;
import net.andrewcpu.halo.nodes.nodes.game_mode.team.GetTeamPoints;
import net.andrewcpu.halo.nodes.nodes.inventory.*;
import net.andrewcpu.halo.nodes.nodes.inventory.equipment.*;
import net.andrewcpu.halo.nodes.nodes.logic.*;
import net.andrewcpu.halo.nodes.nodes.math.*;
import net.andrewcpu.halo.nodes.nodes.objects.*;
import net.andrewcpu.halo.nodes.nodes.objects.transform.*;
import net.andrewcpu.halo.nodes.nodes.players.*;
import net.andrewcpu.halo.nodes.nodes.traits.*;
import net.andrewcpu.halo.nodes.nodes.ui.*;
import net.andrewcpu.halo.nodes.nodes.ui.nav.*;
import net.andrewcpu.halo.nodes.nodes.variables.advanced.*;
import net.andrewcpu.halo.nodes.nodes.variables.basic.*;
import net.andrewcpu.halo.nodes.nodes.vehicles.*;

import java.util.ArrayList;
import java.util.List;

public class AllNodes {

	public static List<Class> getEventDeclarations() {
		List gameEvents = List.of(GameplayStartEvent.class, GameStartEvent.class, RoundEndEvent.class, RoundStartEvent.class);
		List equipmentEvents = List.of(EquipmentPickupEvent.class, EquipmentUsedEvent.class);
		List weaponEvents = List.of(GrenadePickupEvent.class, GrenadeThrowEvent.class, WeaponAddedEvent.class, WeaponDroppedEvent.class, WeaponLowAmmoEvent.class, WeaponNoAmmoEvent.class, WeaponPickupEvent.class, WeaponRefillPickupEvent.class);
		List objectEvents = List.of(ObjectDamagedEvent.class, ObjectDestroyedEvent.class, ObjectEnteredAreaEvent.class, ObjectExitedAreaEvent.class, ObjectSpawnedEvent.class);
		List playerEvents = List.of(PlayerCrouchEvent.class, PlayerExitedEvent.class, PlayerJoinedEvent.class, PlayerKilledEvent.class, PlayerMarkEvent.class, PlayerSpawnedEvent.class, PlayerTeamChangeEvent.class);
		List vehicleEvents = List.of(VehicleEnteredEvent.class, VehicleExitedEvent.class, VehicleHijackedEvent.class, VehicleOverturnedEvent.class);
		List<Class> output = new ArrayList<>();
		output.addAll(gameEvents);
		output.addAll(equipmentEvents);
		output.addAll(weaponEvents);
		output.addAll(objectEvents);
		output.addAll(playerEvents);
		output.addAll(vehicleEvents);
		return output;
	}

	public static List<Class> getAllNodes() {
		List audio = List.of(Play3DAudioForAllPlayers.class, Play3DAudioForAllTeams.class, Play3DAudioForTeam.class, RegisterAudioZone.class, SetObject3DAudioLoop.class, StopObject3DAudioLoop.class, UnregisterAudioZone.class);
		List bots = List.of(AddBot.class, BotDifficulty.class, GetBotIsDifficulty.class, GetIsBot.class, RemoveAllBots.class, RemoveSpecificBot.class);
		List custom = List.of(EveryNSecondsEvent.class);
		List gameEvents = List.of(GameplayStartEvent.class, GameStartEvent.class, RoundEndEvent.class, RoundStartEvent.class);
		List equipmentEvents = List.of(EquipmentPickupEvent.class, EquipmentUsedEvent.class);
		List weaponEvents = List.of(GrenadePickupEvent.class, GrenadeThrowEvent.class, WeaponAddedEvent.class, WeaponDroppedEvent.class, WeaponLowAmmoEvent.class, WeaponNoAmmoEvent.class, WeaponPickupEvent.class, WeaponRefillPickupEvent.class);
		List objectEvents = List.of(ObjectDamagedEvent.class, ObjectDestroyedEvent.class, ObjectEnteredAreaEvent.class, ObjectExitedAreaEvent.class, ObjectSpawnedEvent.class);
		List playerEvents = List.of(PlayerCrouchEvent.class, PlayerExitedEvent.class, PlayerJoinedEvent.class, PlayerKilledEvent.class, PlayerMarkEvent.class, PlayerSpawnedEvent.class, PlayerTeamChangeEvent.class);
		List vehicleEvents = List.of(VehicleEnteredEvent.class, VehicleExitedEvent.class, VehicleHijackedEvent.class, VehicleOverturnedEvent.class);
		List gameGamemode = List.of(EndRound.class, EndRoundAllLose.class, EndRoundAllTie.class, EndRoundWinningPlayer.class, EndRoundWinningTeam.class, GetCurrentRound.class, GetMaxRounds.class, GetPointsToWin.class, GetRoundTime.class, SetPointsToWin.class, SetRoundTime.class);
		List playerGamemode = List.of(AdjustPersonalScore.class, AdjustPlayerPoints.class, GetPersonalScore.class, GetPlayerPoints.class);
		List teamGamemode = List.of(AdjustTeamPoints.class, GetTeamPoints.class);
		List equipment = List.of(AdjustPlayerEquipmentCharges.class, AdjustPlayerGrenades.class, AreSameEquipmentType.class, EmptyPlayerEquipment.class, EmptyPlayerGrenades.class, GetEquipmentType.class, GetIsHoldingAnyEquipment.class, GetIsHoldingEquipmentType.class, GetLoadoutGrenadeCount.class, GetPlayerEquipmentCharges.class, GetPlayerGrenadeCount.class, GivePlayerNewEquipment.class, RefillDefaultGrenades.class, SetPlayerEquipmentCharges.class);
		List inventory = List.of(AddPlayerAmmoEquipped.class, AddPlayerAmmoUnequipped.class, AreSameWeaponType.class, DropSpecificWeapon.class, DropWeaponOfType.class, EmptyPlayerAmmo.class, GetIsHoldingSpecificWeapon.class, GetIsHoldingWeaponType.class, GetIsWeaponType.class, GetPlayerHoldingItem.class, GetPlayerWeapons.class, GetWeaponMagazineCapacity.class, GetWeaponMagazineRounds.class, GetWeaponType.class, GivePlayerNewWeapon.class, GivePlayerSpecificWeapon.class, RefillPlayerAmmo.class, SetPlayerWeaponLowered.class, SwitchToFirstWeaponOfType.class);
		List logic = List.of(BooleanLogic.class, Branch.class, Compare.class, CompareEquipmentTypes.class, CompareGrenadeTypes.class, CompareTeams.class, CompareVehicleTypes.class, CompareWeaponTypes.class, ForEachObject.class, ForEachPlayer.class, ForNIterations.class, GetIsForgeMode.class, WaitForNSeconds.class);
		List math = List.of(AbsoluteValue.class, Add.class, AddVectors.class, ArcsinArccos.class, Arctan.class, ConvertDegreesToRadians.class, ConvertRadiansToDegrees.class, CosSinTan.class, Divide.class, GetPi.class, GetRandomRotation.class, GetVectorAxisValue.class, GetVectorLength.class, Multiply.class, NormalizeVector.class, RandomBoolean.class, RandomNumber.class, RoundToWholeNumber.class, ScaleVector.class, SquareRoot.class, Subtract.class, SubtractVectors.class, VectorCrossProduct.class, VectorDotProduct.class);
		List transform = List.of(GetObjectAngularVelocity.class, GetObjectForward.class, GetObjectPosition.class, GetObjectRotation.class, GetObjectUp.class, GetObjectVelocity.class, MoveObjectToTransform.class, ResetObject.class, RotateObjectToPoint.class, SetObjectAngularVelocity.class, SetObjectPosition.class, SetObjectRotation.class, SetObjectVelocity.class, TranslateObjectToPoint.class);
		List objects = List.of(AddObjectToList.class, AreSameObject.class, CombineObjectLists.class, DamageObject.class, DeleteObject.class, GetAllSpawnPoints.class, GetAllSpawnPointsForTeam.class, GetFirstNObjects.class, GetIsDead.class, GetIsValidObject.class, GetLastNObjects.class, GetListSize.class, GetObjectAtIndex.class, GetObjectHealth.class, GetObjectShield.class, GetObjectsInAreaMonitor.class, GetObjectsInPrefab.class, GetObjectTeam.class, GetRandomNObjects.class, GetSharedObjects.class, GetUniqueObjects.class, ObjectIsInList.class, RemoveObjectFromList.class, SetSpawnPointEnabled.class, SpawnObject.class);
		List players = List.of(AreSamePlayer.class, BlockPlayerRespawns.class, GetAllPlayers.class, GetAllPlayersOnTeam.class, GetIsAirborne.class, GetIsCamouflaged.class, GetIsCrouching.class, GetIsDetected.class, GetIsDetectedByTeam.class, GetIsGrappling.class, GetIsInKnockback.class, GetIsLunging.class, GetIsMarkOverridden.class, GetIsOvershieldOn.class, GetIsPlayer.class, GetIsZoomed.class, GetNumberOfPlayers.class, GetNumberOfTeams.class, GetPlayerAimingVector.class, GetPlayerFFAAllegiance.class, GetPlayerTeam.class, GetRandomPlayer.class, GetRespawnPenalty.class, SetPlayerCamo.class, SetPlayerFFAAllegiance.class, SetPlayerMarkOverride.class, SetPlayerTeam.class, SetRespawnPenalty.class, TeleportPlayer.class, UnblockRespawnsForPlayer.class);
		List traits = List.of(ApplyTraitSet.class, ApplyTraitSetForSeconds.class, ApplyTraitSetUntilDeath.class, CombineTraitLists.class, DeclareTraitSet.class, GetRandomNTraits.class, RemoveAllTraitSets.class, RemoveTraitSet.class, TraitBonusHealth.class, TraitBonusShield.class, TraitBottomlessClip.class, TraitClamberEnabled.class, TraitClamberSpeed.class, TraitDamageResistance.class, TraitDeathless.class, TraitEquipmentPickup.class, TraitGrenadeDamage.class, TraitGrenadeDetonationRadius.class, TraitGrenadeImpulse.class, TraitGrenadePickup.class, TraitHeadshotProtection.class, TraitHealthRecharge.class, TraitInfiniteAmmo.class, TraitJumpHeight.class, TraitList.class, TraitLoadoutWeaponOverrides.class, TraitMeleeDamage.class, TraitMeleeImpulse.class, TraitMeleeRecoverySpeed.class, TraitMotionTrackerRange.class, TraitMotionTrackerVisible.class, TraitMovementSpeed.class, TraitMovementSpeedWithTurret.class, TraitPlayerGravity.class, TraitPreventGrenadeThrowing.class, TraitPreventWeaponFiring.class, TraitReloadSpeed.class, TraitShieldHUDVisible.class, TraitShieldRecharge.class, TraitSlideSpeed.class, TraitSprintEnabled.class, TraitSprintReloadEnabled.class, TraitSprintResetsRecharge.class, TraitSprintSpeed.class, TraitVamporism.class, TraitVehiclePassengerOnly.class, TraitVFXActiveCamo.class, TraitVFXOvershield.class, TraitWeaponDamage.class, TraitWeaponDropping.class, TraitWeaponPickup.class, TraitWeaponSwitchSpeed.class);
		List nav = List.of(AttachNavMarkerToObject.class, ClearNavMarkerTeam.class, NavMarker.class, SetNavMarkerEnabled.class, SetNavMarkerPosition.class, SetNavMarkerTeam.class, SetNavMarkerTeamVisibility.class, SetNavMarkerText.class);
		List ui = List.of(ClearSplashForPlayer.class, CreateUIMessage.class, CreateUIMessageB.class, PrintBooleanToKillfeed.class, PrintNumberToKillfeed.class, PrintPlayerToKillfeed.class, PrintTeamToKillfeed.class, PrintVector3ToKillfeed.class, PushSplashToPlayer.class, SetObjectiveBannerForPlayer.class);
		List advanced = List.of(DeclareBooleanVariable.class, DeclareEquipmentTypeVariable.class, DeclareGrenadeTypeVariable.class, DeclareNumberVariable.class, DeclareObjectListVariable.class, DeclareObjectVariable.class, DeclareStringVariable.class, DeclareTeamVariable.class, DeclareUIMessageVariable.class, DeclareVector3Variable.class, DeclareVehicleTypeVariable.class, DeclareWeaponTypeVariable.class, GetBooleanVariable.class, GetEquipmentTypeVariable.class, GetGrenadeTypeVariable.class, GetNumberVariable.class, GetObjectListVariable.class, GetObjectVariable.class, GetStringVariable.class, GetTeamVariable.class, GetUIMessageVariable.class, GetVector3Variable.class, GetVehicleTypeVariable.class, GetWeaponTypeVariable.class, SetBooleanVariable.class, SetEquipmentTypeVariable.class, SetGrenadeTypeVariable.class, SetNumberVariable.class, SetObjectListVariable.class, SetObjectVariable.class, SetStringVariable.class, SetTeamVariable.class, SetUIMessageVariable.class, SetVector3Variable.class, SetVehicleTypeVariable.class, SetWeaponTypeVariable.class);
		List basic = List.of(AreaMonitorVariable.class, BooleanVariable.class, EquipmentTypeVariable.class, GrenadeTypeVariable.class, IdentifierVariable.class, NumberVariable.class, ObjectListVariable.class, ObjectReferenceVariable.class, StringVariable.class, TeamVariable.class, Vector3Variable.class, VehicleTypeVariable.class, WeaponTypeCombinationVariable.class, WeaponTypeVariable.class);
		List vehicles = List.of(AreSameVehicleType.class, GetIsBoarding.class, GetIsDrivingVehicle.class, GetIsGunnerInVehicle.class, GetIsInVehicle.class, GetIsOverturned.class, GetPlayerVehicle.class, GetSquaredVehicleSpeed.class, GetVehicleDriver.class, GetVehicleEnterableByPlayer.class, GetVehicleGunner.class, GetVehicleOccupants.class, GetVehicleType.class);
		List<Class> classes = new ArrayList<>();
		classes.addAll(audio);
		classes.addAll(bots);
		classes.addAll(custom);
		classes.addAll(gameEvents);
		classes.addAll(equipmentEvents);
		classes.addAll(weaponEvents);
		classes.addAll(objectEvents);
		classes.addAll(playerEvents);
		classes.addAll(vehicleEvents);
		classes.addAll(gameGamemode);
		classes.addAll(playerGamemode);
		classes.addAll(teamGamemode);
		classes.addAll(equipment);
		classes.addAll(inventory);
		classes.addAll(logic);
		classes.addAll(math);
		classes.addAll(transform);
		classes.addAll(objects);
		classes.addAll(players);
		classes.addAll(traits);
		classes.addAll(nav);
		classes.addAll(ui);
		classes.addAll(advanced);
		classes.addAll(basic);
		classes.addAll(vehicles);
		return classes;
	}
}
