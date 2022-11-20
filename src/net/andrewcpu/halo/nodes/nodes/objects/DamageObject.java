package net.andrewcpu.halo.nodes.nodes.objects;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.ObjectType;

public class DamageObject extends IONode {
	public DamageObject() {
		super("Damage Object", new DataType[]{new ObjectType("object"), new NumberType("damage")}, new DataType[]{});
	}
}
