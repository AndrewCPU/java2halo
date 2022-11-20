package net.andrewcpu.halo.nodes.nodes.traits;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.IdentifierType;
import net.andrewcpu.halo.type.TraitType;
import net.andrewcpu.halo.type.TraitsType;

public class DeclareTraitSet extends DataNode {
	public DeclareTraitSet() {
		super("Declare Trait Set", new DataType[]{new IdentifierType("identifier"), new TraitType("a"), new TraitType("b"), new TraitsType("traitList")}, new DataType[]{});
	}
}
