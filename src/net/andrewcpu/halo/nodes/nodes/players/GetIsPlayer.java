package net.andrewcpu.halo.nodes.nodes.players;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectType;

public class GetIsPlayer extends DataNode {
	public GetIsPlayer(){
		super("Get is Player", new DataType[]{new ObjectType("object")}, new DataType[]{new BooleanType("isPlayer")});
	}
}
