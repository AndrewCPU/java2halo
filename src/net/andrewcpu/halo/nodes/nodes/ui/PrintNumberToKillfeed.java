package net.andrewcpu.halo.nodes.nodes.ui;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;

public class PrintNumberToKillfeed extends IONode {
	public PrintNumberToKillfeed() {
		super("Print Number to Killfeed", new DataType[]{new NumberType("value")}, new DataType[]{});
	}
}
