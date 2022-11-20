package net.andrewcpu.halo.nodes.nodes.events.game;

import net.andrewcpu.halo.nodes.OutputOnlyNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;

public class RoundStartEvent extends OutputOnlyNode {
	public RoundStartEvent() {
		super("Round Start Event", new DataType[]{}, new DataType[]{new NumberType("round")});
	}
}
