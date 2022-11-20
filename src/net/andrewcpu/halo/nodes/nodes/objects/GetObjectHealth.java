package net.andrewcpu.halo.nodes.nodes.objects;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.ObjectType;

public class GetObjectHealth extends DataNode {
	public GetObjectHealth() {
		super("Get Object Health", new DataType[]{new ObjectType("object")}, new DataType[]{new NumberType("percent"), new NumberType("health"), new NumberType("max")});
	}
}
