package net.andrewcpu.halo.nodes.nodes.objects;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectType;

public class GetIsDead extends DataNode {
	public GetIsDead() {
		super("Get is Dead", new DataType[]{new ObjectType("object")}, new DataType[]{new BooleanType("isDead")});
	}
}
