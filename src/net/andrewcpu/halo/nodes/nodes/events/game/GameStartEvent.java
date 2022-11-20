package net.andrewcpu.halo.nodes.nodes.events.game;

import net.andrewcpu.halo.nodes.OutputOnlyNode;
import net.andrewcpu.halo.type.DataType;

public class GameStartEvent extends OutputOnlyNode {
	public GameStartEvent() {
		super("Game Start Event", new DataType[]{}, new DataType[]{});
	}
}
