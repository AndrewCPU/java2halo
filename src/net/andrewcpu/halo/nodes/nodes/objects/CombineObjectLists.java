package net.andrewcpu.halo.nodes.nodes.objects;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectsType;

public class CombineObjectLists extends DataNode {
	public CombineObjectLists() {
		super("Combine Object Lists", new DataType[]{new ObjectsType("a"), new ObjectsType("b")}, new DataType[]{new ObjectsType("combined")});
	}
}
