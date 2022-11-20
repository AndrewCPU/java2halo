package net.andrewcpu.halo.nodes.nodes.logic;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;

public class Compare extends DataNode {
	public Compare() {
		super("Compare", new DataType[]{new NumberType("a"), new NumberType("b")}, new DataType[]{new BooleanType("equal"), new BooleanType("greater"), new BooleanType("less")});
	}
}
