package net.andrewcpu.halo.nodes.nodes.events.game;

import net.andrewcpu.halo.nodes.OutputOnlyNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;

public class RoundEndEvent extends OutputOnlyNode {
	public RoundEndEvent() {
		super("Round End Event", new DataType[]{}, new DataType[]{new NumberType("round")});
	}
}
