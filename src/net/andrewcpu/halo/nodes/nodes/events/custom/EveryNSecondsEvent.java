package net.andrewcpu.halo.nodes.nodes.events.custom;

import net.andrewcpu.halo.nodes.OutputOnlyNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;

public class EveryNSecondsEvent extends OutputOnlyNode {
	public EveryNSecondsEvent() {
		super("Every N Seconds Event", new DataType[]{new NumberType("seconds"), new NumberType("initialDelay")}, new DataType[]{});
	}
}
