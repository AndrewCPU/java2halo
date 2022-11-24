package net.andrewcpu.halo.type;

import net.andrewcpu.halo.nodes.Node;
import net.andrewcpu.halo.nodes.nodes.logic.BooleanLogic;
import net.andrewcpu.halo.nodes.nodes.logic.Compare;

public class NumberType  extends DataType implements ComparableType{
	public NumberType(String name) {
		super(name);
	}

	@Override
	public Class<? extends Node> getComparisonNode() {
		return Compare.class;
	}
}
