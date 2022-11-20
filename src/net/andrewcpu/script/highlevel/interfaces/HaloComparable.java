package net.andrewcpu.script.highlevel.interfaces;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.nodes.Node;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.script.highlevel.ComplexNodeBundle;
import net.andrewcpu.script.highlevel.HighLevelObject;
import net.andrewcpu.script.highlevel.SimpleNodeBundle;

public interface HaloComparable<F extends DataType, T extends HighLevelObject<F>, Q extends Node> {
	public SimpleNodeBundle<F, Q> equals(T other);
	public SimpleNodeBundle<F, Q> greaterThan(T other);
	public SimpleNodeBundle<F, Q> lessThan(T other);
}
