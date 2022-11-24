package net.andrewcpu.halo.type;

import net.andrewcpu.halo.nodes.Node;
import net.andrewcpu.halo.nodes.nodes.logic.BooleanLogic;

public class BooleanType extends DataType implements ComparableType{
	public BooleanType(String name) {
		super(name);
	}

	@Override
	public Class<? extends Node> getComparisonNode() {
		return BooleanLogic.class;
	}
}
