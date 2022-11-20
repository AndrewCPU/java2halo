package net.andrewcpu.script.highlevel.types;

import net.andrewcpu.halo.type.TeamType;
import net.andrewcpu.script.highlevel.HighLevelObject;
import net.andrewcpu.script.highlevel.interfaces.HaloConstant;

public class Team extends HighLevelObject<TeamType> implements HaloConstant<TeamType, Team> {
	public Team() {
		super(false);
	}

	@Override
	public java.lang.String[] getConstants() {
		return new java.lang.String[]{
				"eagle",
				"cobra",
				"hades",
				"valkyrie",
				"rampart",
				"cutlass",
				"valor",
				"hazard"
		};
	}

	@Override
	public Class<TeamType> getDataType() {
		return TeamType.class;
	}

	@Override
	public Class<Team> getObjectType() {
		return Team.class;
	}
}
