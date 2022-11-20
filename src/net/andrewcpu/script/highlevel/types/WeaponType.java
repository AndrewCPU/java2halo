package net.andrewcpu.script.highlevel.types;

import net.andrewcpu.halo.type.WeaponTypeType;
import net.andrewcpu.script.highlevel.HighLevelObject;
import net.andrewcpu.script.highlevel.TypedFunctionResult;
import net.andrewcpu.script.highlevel.interfaces.HaloConstant;

public class WeaponType extends HighLevelObject<WeaponTypeType> implements HaloConstant<WeaponTypeType, WeaponType> {
	public WeaponType() {
		super(false);
	}

	@Override
	public java.lang.String[] getConstants() {
		return new java.lang.String[]{
				"arcane_sentinel_beam",
				"br75",
				"br75_breacher",
				"backdraft_cindershot",
				"cqs48_bulldog",
				"calcine_disruptor",
				"cindershot",
				"convergence_bulldog",
				"diminisher_of_hope",
				"disruptor",
				"duelist_energy_sword",
				"elite_bloodblade",
				"energy_sword",
				"gravity_hammer",
				"heatwave",
				"impact_commando",
				"m41_spnkr",
				"m41_tracker",
				"ma40_assault_rifle",
				"ma40_long_shot",
				"mlrs2_hydra",
				"mangler",
				"mk50_sidekick",
				"needler",
				"none",
				"pinpoint_needler",
				"plasma_pistol",
				"pulse_carbine",
				"purging_shock_rifle",
				"pursuit_hydra",
				"rapidfire_pulse_carbine",
				"ravager",
				"ravager_rebound",
				"riven_mangler",
				"rushdown_hammer",
				"s7_flexfire_sniper",
				"s7_sniper_rifle",
				"scatterbound_heatwave",
				"sentinel_beam",
				"shock_rifle",
				"skewer",
				"stalker_rifle",
				"stalker_rifle_ultra",
				"striker_sidekick",
				"unbound_plasma_pistol",
				"vk78_commando_rifle",
				"volatile_skewer"
		};
	}


	@Override
	public Class<WeaponTypeType> getDataType() {
		return WeaponTypeType.class;
	}

	@Override
	public Class<WeaponType> getObjectType() {
		return WeaponType.class;
	}
}
