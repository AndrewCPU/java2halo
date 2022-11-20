package net.andrewcpu.halo.nodes.nodes.objects.transform;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectType;
import net.andrewcpu.halo.type.VectorType;

public class SetObjectVelocity extends IONode {
	public SetObjectVelocity() {
		super("Set Object Velocity", new DataType[]{new ObjectType("object"), new VectorType("velocity"), new BooleanType("relative")}, new DataType[]{});
	}
}
