package net.andrewcpu.halo.nodes.nodes.bots;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.BotPlayerType;
import net.andrewcpu.halo.type.DataType;

public class RemoveSpecificBot extends IONode {
	public RemoveSpecificBot() {
		super("Remove Specific Bot", new DataType[]{new BotPlayerType()}, new DataType[]{});
	}
}
