package net.andrewcpu.halo.nodes.nodes.events.object;

import net.andrewcpu.halo.nodes.OutputOnlyNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.ObjectType;

public class ObjectDamagedEvent extends OutputOnlyNode {
	public ObjectDamagedEvent() {
		super("Object Damaged Event", new DataType[]{new ObjectType("object")}, new DataType[]{new ObjectType("attacker"), new NumberType("damageAmount")});
	}
}
