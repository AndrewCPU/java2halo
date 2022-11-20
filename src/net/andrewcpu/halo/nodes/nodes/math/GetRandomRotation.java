package net.andrewcpu.halo.nodes.nodes.math;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.VectorType;

public class GetRandomRotation extends DataNode {
	public GetRandomRotation() {
		super("Get Random Rotation", new DataType[]{}, new DataType[]{new VectorType("rotation")});
	}
}
