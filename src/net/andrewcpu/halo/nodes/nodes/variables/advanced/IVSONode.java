package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.IdentifierType;
import net.andrewcpu.halo.type.ObjectType;
import net.andrewcpu.halo.type.ScopeType;

public abstract class IVSONode<T extends DataType> extends IONode {
	private T dt;
	public IVSONode(String name, T value) {
		super(name, new DataType[]{new IdentifierType("identifier"), value, new ScopeType("scope"), new ObjectType("object")}, new DataType[]{});
		this.dt = value;
	}

	public T getDataType() {
		return dt;
	}
}
