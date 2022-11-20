package net.andrewcpu.halo.nodes.nodes.math;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;

public class GetPi extends DataNode {
	public GetPi() {
		super("Get Pi", new DataType[]{}, new DataType[]{new NumberType("pi")});
	}
}
