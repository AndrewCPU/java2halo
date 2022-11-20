package net.andrewcpu.halo.nodes.nodes.objects.transform;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectType;
import net.andrewcpu.halo.type.VectorType;

public class SetObjectAngularVelocity extends IONode {
	public SetObjectAngularVelocity() {
		super("Set Object Angular Velocity", new DataType[]{new ObjectType("object"), new VectorType("angularVelocity"), new BooleanType("relative")}, new DataType[]{});
	}
}
