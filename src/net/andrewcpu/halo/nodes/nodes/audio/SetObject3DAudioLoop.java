package net.andrewcpu.halo.nodes.nodes.audio;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectType;

public class SetObject3DAudioLoop extends IONode {
	public SetObject3DAudioLoop() {
		super("Set Object 3D Audio Loop", new DataType[]{new ObjectType("object"), new BooleanType("playForEnemies"), new BooleanType("playForAllies")}, new DataType[]{});
	}
}
