package net.andrewcpu.halo.nodes.nodes.objects.transform;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectType;
import net.andrewcpu.halo.type.VectorType;

public class SetObjectRotation extends IONode {
	public SetObjectRotation() {
		super("Set Object Rotation", new DataType[]{new ObjectType("object"), new VectorType("rotation"), new BooleanType("relative")}, new DataType[]{});
	}
}
