package net.andrewcpu.halo.nodes.nodes.bots;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BotDifficultyType;
import net.andrewcpu.halo.type.DataType;

public class BotDifficulty extends DataNode {
	public BotDifficulty() {
		super("Bot Difficulty", new DataType[]{}, new DataType[]{new BotDifficultyType("difficulty")});
	}
}
