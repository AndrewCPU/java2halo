package net.andrewcpu.halo.nodes.nodes.players;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;

public class GetNumberOfTeams extends DataNode {
	public GetNumberOfTeams() {
		super("Get Number of Teams", new DataType[]{}, new DataType[]{new NumberType("count")});
	}
}
