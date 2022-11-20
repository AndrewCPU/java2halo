package net.andrewcpu.halo.nodes.nodes.audio;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectType;

public class StopObject3DAudioLoop extends IONode {
	public StopObject3DAudioLoop() {
		super("Stop Object 3D Audio Loop", new DataType[]{new ObjectType("object"), new BooleanType("stopForAllies"), new BooleanType("stopForEnemies")}, new DataType[]{});
	}
}
