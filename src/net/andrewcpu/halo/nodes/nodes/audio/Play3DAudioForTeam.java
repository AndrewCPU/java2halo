package net.andrewcpu.halo.nodes.nodes.audio;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.TeamType;
import net.andrewcpu.halo.type.VectorType;

public class Play3DAudioForTeam extends IONode {
	public Play3DAudioForTeam() {
		super("Play 3D Audio for Team", new DataType[]{new TeamType("team"), new VectorType("position")}, new DataType[]{});
	}
}
