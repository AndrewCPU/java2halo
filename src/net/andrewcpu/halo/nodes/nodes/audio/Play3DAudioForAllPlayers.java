package net.andrewcpu.halo.nodes.nodes.audio;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.VectorType;

public class Play3DAudioForAllPlayers extends IONode {
	public Play3DAudioForAllPlayers() {
		super("Play 3D Audio for all Players", new DataType[]{new VectorType("position")}, new DataType[]{});
	}
}
