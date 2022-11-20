package net.andrewcpu.halo.nodes.nodes.math;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;

public class ArcsinArccos extends DataNode {
	public ArcsinArccos() { // arccos, arcsin
		super("Arc sin & Arc cos", new DataType[]{new NumberType("a")}, new DataType[]{new NumberType("arccos"), new NumberType("arcsin")});
	}
}
