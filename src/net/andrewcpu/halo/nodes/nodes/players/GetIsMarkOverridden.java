package net.andrewcpu.halo.nodes.nodes.players;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;

public class GetIsMarkOverridden extends DataNode {
	public GetIsMarkOverridden(){
		super("Get is Mark Overridden", new DataType[]{new PlayerType("player")}, new DataType[]{new BooleanType("isOverridden")});
	}
}
