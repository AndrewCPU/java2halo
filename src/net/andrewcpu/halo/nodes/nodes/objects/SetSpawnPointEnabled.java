package net.andrewcpu.halo.nodes.nodes.objects;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectType;

public class SetSpawnPointEnabled extends IONode {
	public SetSpawnPointEnabled() {
		super("Set Spawn Point Enabled", new DataType[]{new ObjectType("spawnPoint"), new BooleanType("enabled")}, new DataType[]{});
	}
}
