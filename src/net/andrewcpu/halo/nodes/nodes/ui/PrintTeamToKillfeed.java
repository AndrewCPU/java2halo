package net.andrewcpu.halo.nodes.nodes.ui;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.TeamType;

public class PrintTeamToKillfeed extends IONode {
	public PrintTeamToKillfeed() {
		super("Print Team to Killfeed", new DataType[]{new TeamType("value")}, new DataType[]{});
	}
}
