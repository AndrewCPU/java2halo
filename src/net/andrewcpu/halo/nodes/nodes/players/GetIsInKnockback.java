package net.andrewcpu.halo.nodes.nodes.players;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;

public class GetIsInKnockback extends DataNode {
	public GetIsInKnockback(){
		super("Get is in Knockback", new DataType[]{new PlayerType("player")}, new DataType[]{new BooleanType("isInKnockback")});
	}
}
