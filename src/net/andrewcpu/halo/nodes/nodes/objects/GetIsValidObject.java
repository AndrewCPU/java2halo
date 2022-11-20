package net.andrewcpu.halo.nodes.nodes.objects;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectType;

public class GetIsValidObject extends DataNode {
	public GetIsValidObject() {
		super("Get is Valid Object", new DataType[]{new ObjectType("object")}, new DataType[]{new BooleanType("isValid")});
	}
}
