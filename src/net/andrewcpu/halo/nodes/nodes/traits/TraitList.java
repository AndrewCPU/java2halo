package net.andrewcpu.halo.nodes.nodes.traits;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.TraitType;
import net.andrewcpu.halo.type.TraitsType;

public class TraitList extends DataNode {
	public TraitList() {
		super("Trait List", new DataType[]{new TraitType("a"), new TraitType("b"), new TraitType("c"), new TraitType("d")}, new DataType[]{new TraitsType("traitList")});
	}
}
