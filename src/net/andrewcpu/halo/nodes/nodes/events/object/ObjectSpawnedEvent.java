package net.andrewcpu.halo.nodes.nodes.events.object;

import net.andrewcpu.halo.nodes.OutputOnlyNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectType;

public class ObjectSpawnedEvent extends OutputOnlyNode {
	public ObjectSpawnedEvent() {
		super("Object Spawned Event", new DataType[]{new ObjectType("object")}, new DataType[]{});
	}
}
