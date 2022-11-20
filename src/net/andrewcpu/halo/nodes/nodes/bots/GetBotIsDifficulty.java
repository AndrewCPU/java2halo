package net.andrewcpu.halo.nodes.nodes.bots;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.BotDifficultyType;
import net.andrewcpu.halo.type.BotPlayerType;
import net.andrewcpu.halo.type.DataType;

public class GetBotIsDifficulty extends DataNode {
	public GetBotIsDifficulty() {
		super("Get Bot is Difficulty", new DataType[]{new BotPlayerType(), new BotDifficultyType("difficulty")}, new DataType[]{new BooleanType("isDifficulty")});
	}
}
