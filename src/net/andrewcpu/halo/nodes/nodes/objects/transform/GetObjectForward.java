package net.andrewcpu.halo.nodes.nodes.objects.transform;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectType;
import net.andrewcpu.halo.type.VectorType;

public class GetObjectForward extends DataNode {
	public GetObjectForward() {
		super("Get Object Forward", new DataType[]{new ObjectType("object")}, new DataType[]{new VectorType("forward")});
	}
}
