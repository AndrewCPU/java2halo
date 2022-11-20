package net.andrewcpu.halo.nodes.nodes.objects;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.ObjectType;

public class GetObjectShield extends DataNode {
	public GetObjectShield() {
		super("Get Object Shield", new DataType[]{new ObjectType("object")}, new DataType[]{new NumberType("percent"), new NumberType("shield"), new NumberType("max")});
	}
}
