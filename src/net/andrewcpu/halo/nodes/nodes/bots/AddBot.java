package net.andrewcpu.halo.nodes.nodes.bots;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.BotDifficultyType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.TeamType;

public class AddBot extends IONode {
	public AddBot() {
		super("Add Bot", new DataType[]{new BotDifficultyType("difficulty"), new TeamType("team")}, new DataType[]{});
	}
}
