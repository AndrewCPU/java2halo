package net.andrewcpu.halo.nodes.nodes.ui;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;

public class PrintBooleanToKillfeed extends IONode {
	public PrintBooleanToKillfeed() {
		super("Print Boolean to Killfeed", new DataType[]{new BooleanType("value")}, new DataType[]{});
	}
}
