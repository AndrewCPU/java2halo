package net.andrewcpu.halo.nodes.nodes.traits;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.TraitsType;

public class CombineTraitLists extends DataNode {
	public CombineTraitLists() {
		super("Combine Trait Lists", new DataType[]{new TraitsType("a"), new TraitsType("b"), new TraitsType("c")}, new DataType[]{new TraitsType("combined")});
	}
}
