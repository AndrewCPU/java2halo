package net.andrewcpu.halo.nodes.nodes.logic;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;

public class GetIsForgeMode extends DataNode {
	public GetIsForgeMode() {
		super("Get is Forge Mode", new DataType[]{}, new DataType[]{new BooleanType("isForge")});
	}
}
