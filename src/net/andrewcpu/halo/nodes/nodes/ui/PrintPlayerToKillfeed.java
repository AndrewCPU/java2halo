package net.andrewcpu.halo.nodes.nodes.ui;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;

public class PrintPlayerToKillfeed extends IONode {
	public PrintPlayerToKillfeed() {
		super("Print Player to Killfeed", new DataType[]{new PlayerType("value")}, new DataType[]{});
	}
}
