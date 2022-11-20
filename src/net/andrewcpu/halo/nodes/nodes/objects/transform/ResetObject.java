package net.andrewcpu.halo.nodes.nodes.objects.transform;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectType;

public class ResetObject extends IONode {
	public ResetObject() {
		super("Reset Object", new DataType[]{new ObjectType("object"), new BooleanType("position"), new BooleanType("rotation"), new BooleanType("velocity")}, new DataType[]{});
	}
}
