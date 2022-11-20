package net.andrewcpu.halo.nodes.nodes.objects;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectType;

public class DeleteObject extends IONode {
	public DeleteObject() {
		super("Delete Object", new DataType[]{new ObjectType("object")}, new DataType[]{});
	}
}
