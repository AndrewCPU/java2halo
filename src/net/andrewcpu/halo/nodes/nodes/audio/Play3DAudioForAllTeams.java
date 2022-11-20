package net.andrewcpu.halo.nodes.nodes.audio;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.VectorType;

public class Play3DAudioForAllTeams extends IONode {
	public Play3DAudioForAllTeams() {
		super("Play 3D Audio for All Teams", new DataType[]{new VectorType("position")}, new DataType[]{});
	}
}
