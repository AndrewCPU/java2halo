package net.andrewcpu.halo.nodes.nodes.math;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;

public class ConvertDegreesToRadians extends DataNode {
	public ConvertDegreesToRadians() {
		super("Convert Degrees to Radians", new DataType[]{new NumberType("degrees")}, new DataType[]{new NumberType("radians")});
	}
}
