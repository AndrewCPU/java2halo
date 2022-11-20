package net.andrewcpu.halo.nodemesh;

import net.andrewcpu.halo.nodes.nodes.game_mode.team.AdjustTeamPoints;
import net.andrewcpu.halo.nodes.nodes.game_mode.team.GetTeamPoints;
import net.andrewcpu.halo.nodes.nodes.logic.CompareTeams;
import net.andrewcpu.halo.nodes.nodes.objects.GetAllSpawnPointsForTeam;
import net.andrewcpu.halo.nodes.nodes.players.GetAllPlayersOnTeam;
import net.andrewcpu.halo.nodes.nodes.ui.PrintTeamToKillfeed;
import net.andrewcpu.halo.type.TeamType;

import java.util.List;

public class TeamMaster extends MasterCollection<TeamType> {
	@Override
	public Class<TeamType> getDataType() {
		return TeamType.class;
	}

	public List<PrefillNodeValue> getters() {
		return List.of(
				PrefillNodeValue.of(CompareTeams.class, 0, "equal"),
				PrefillNodeValue.of(GetTeamPoints.class, 0, "getPoints"),
				PrefillNodeValue.of(GetAllSpawnPointsForTeam.class, 0, "getAllSpawnPoints"),
				PrefillNodeValue.of(GetAllPlayersOnTeam.class, 0, "getPlayers")
		);
	}
	public List<PrefillNodeValue> setters() {
		return List.of();
	}
	public List<PrefillNodeValue> functions() {
		return List.of(
				PrefillNodeValue.of(AdjustTeamPoints.class, 0, "adjustPoints"),
				PrefillNodeValue.of(PrintTeamToKillfeed.class, 0, "print")
				);
	}

}
