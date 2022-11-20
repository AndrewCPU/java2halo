package net.andrewcpu.halo.nodemesh;

import net.andrewcpu.halo.nodes.nodes.bots.AddBot;
import net.andrewcpu.halo.nodes.nodes.bots.RemoveAllBots;
import net.andrewcpu.halo.nodes.nodes.bots.RemoveSpecificBot;
import net.andrewcpu.halo.nodes.nodes.game_mode.game.*;
import net.andrewcpu.halo.nodes.nodes.objects.SpawnObject;
import net.andrewcpu.halo.nodes.nodes.players.GetAllPlayers;
import net.andrewcpu.halo.nodes.nodes.players.GetRandomPlayer;

import java.util.List;

public class GameMaster extends MasterCollection {
	@Override
	public Class getDataType() {
		return null;
	}

	@Override
	public List<PrefillNodeValue> getters() {
		return List.of(
				PrefillNodeValue.of(GetCurrentRound.class, "getCurrentRound"),
				PrefillNodeValue.of(GetMaxRounds.class, "getMaxRounds"),
				PrefillNodeValue.of(GetPointsToWin.class, "getPointsToWin"),
				PrefillNodeValue.of(GetRoundTime.class, "getRoundTime"),
				PrefillNodeValue.of(GetAllPlayers.class, "getAllPlayers"),
				PrefillNodeValue.of(GetRandomPlayer.class, "getRandomPlayer")

		);
	}

	@Override
	public List<PrefillNodeValue> setters() {
		return List.of(
				PrefillNodeValue.of(SetPointsToWin.class, "setPointsToWin"),
				PrefillNodeValue.of(SetRoundTime.class, "setRoundTime")
		);
	}

	@Override
	public List<PrefillNodeValue> functions() {
		return List.of(
				PrefillNodeValue.of(AddBot.class, "addBot"),
				PrefillNodeValue.of(RemoveAllBots.class, "removeAllBots"),
				PrefillNodeValue.of(RemoveSpecificBot.class, "removeBot"),
				PrefillNodeValue.of(EndRound.class, "endRound"),
				PrefillNodeValue.of(EndRoundAllLose.class, "endRoundAllLose"),
				PrefillNodeValue.of(EndRoundAllTie.class, "endRoundAllTie"),
				PrefillNodeValue.of(EndRoundWinningPlayer.class, "endRoundWithWinningPlayer"),
				PrefillNodeValue.of(EndRoundWinningTeam.class, "endRoundWithWinningTeam"),
				PrefillNodeValue.of(SpawnObject.class, "spawnObject")
		);
	}
}
