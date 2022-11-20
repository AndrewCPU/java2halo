package net.andrewcpu.halo.nodes.nodes.traits;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;

public class RemoveAllTraitSets extends IONode {
	public RemoveAllTraitSets() {
		super("Remove all Trait Sets", new DataType[]{new PlayerType("player"), new BooleanType("immediate")}, new DataType[]{});
	}
}
