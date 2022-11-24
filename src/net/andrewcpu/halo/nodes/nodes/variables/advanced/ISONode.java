package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.IdentifierType;
import net.andrewcpu.halo.type.ObjectType;
import net.andrewcpu.halo.type.ScopeType;

public abstract class ISONode<T extends DataType> extends DataNode {
	private T dt;
	public ISONode(String name, T output) {
		super(name, new DataType[]{new IdentifierType("identifier"), new ScopeType("scope"), new ObjectType("object")}, new DataType[]{output});
		this.dt = output;
	}

	public T getDataType() {
		return dt;
	}
}
