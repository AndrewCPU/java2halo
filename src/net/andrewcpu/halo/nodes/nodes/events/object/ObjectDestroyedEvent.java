package net.andrewcpu.halo.nodes.nodes.events.object;

import net.andrewcpu.halo.nodes.OutputOnlyNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectType;

public class ObjectDestroyedEvent extends OutputOnlyNode {
	public ObjectDestroyedEvent() {
		super("Object Destroyed Event", new DataType[]{new ObjectType("object")}, new DataType[]{});
	}
}
