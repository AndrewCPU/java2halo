package net.andrewcpu.halo.nodes.nodes.math;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;

public class ConvertRadiansToDegrees extends DataNode {
	public ConvertRadiansToDegrees() {
		super("Convert Radians to Degrees", new DataType[]{new NumberType("radians")}, new DataType[]{new NumberType("degrees")});
	}
}
