package net.andrewcpu.halo.nodes.nodes.traits;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.TraitType;

public class BooleanTrait extends DataNode {
	public BooleanTrait(String name, String boolName) {
		super(name, new DataType[]{new BooleanType(boolName)}, new DataType[]{new TraitType("trait")});
	}
}
