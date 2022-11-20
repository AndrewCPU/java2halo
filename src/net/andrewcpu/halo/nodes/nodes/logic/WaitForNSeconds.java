package net.andrewcpu.halo.nodes.nodes.logic;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;

public class WaitForNSeconds extends IONode {
	public WaitForNSeconds() {
		super("Wait For N Seconds", new DataType[]{new NumberType("seconds")}, new DataType[]{});
	}
}
