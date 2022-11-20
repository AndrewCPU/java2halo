package net.andrewcpu.script.highlevel.interfaces;

import net.andrewcpu.halo.nodes.Node;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.script.highlevel.HighLevelObject;
import net.andrewcpu.script.highlevel.SimpleNodeBundle;

public interface HaloArithmetic<F extends DataType, T extends HighLevelObject<F>, A extends Node, B extends Node> {
	SimpleNodeBundle<F, A> add(T other);
	SimpleNodeBundle<F, B> subtract(T other);
}
