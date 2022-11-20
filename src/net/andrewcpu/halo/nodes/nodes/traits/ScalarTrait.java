package net.andrewcpu.halo.nodes.nodes.traits;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.TraitType;

public abstract class ScalarTrait extends DataNode {
	public ScalarTrait(String name, String numberName) {
		super(name, new DataType[]{new NumberType("scalar")}, new DataType[]{new TraitType("trait")});
	}
}
