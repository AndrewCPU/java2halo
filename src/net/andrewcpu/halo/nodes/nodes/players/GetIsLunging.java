package net.andrewcpu.halo.nodes.nodes.players;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;

public class GetIsLunging extends DataNode {
	public GetIsLunging(){
		super("Get is Lunging", new DataType[]{new PlayerType("player")}, new DataType[]{new BooleanType("isLunging")});
	}
}
