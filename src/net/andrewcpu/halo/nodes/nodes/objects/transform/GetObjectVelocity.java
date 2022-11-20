package net.andrewcpu.halo.nodes.nodes.objects.transform;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectType;
import net.andrewcpu.halo.type.VectorType;

public class GetObjectVelocity extends DataNode {
	public GetObjectVelocity() {
		super("Get Object Velocity", new DataType[]{new ObjectType("object")}, new DataType[]{new VectorType("velocity")});
	}
}
