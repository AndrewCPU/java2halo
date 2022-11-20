package net.andrewcpu.halo.nodes.nodes.traits;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.IdentifierType;
import net.andrewcpu.halo.type.PlayerType;

public class ApplyTraitSet extends IONode {
	public ApplyTraitSet() {
		super("Apply Trait Set", new DataType[]{new IdentifierType("identifier"), new PlayerType("player"), new BooleanType("immediate")}, new DataType[]{});
	}
}
