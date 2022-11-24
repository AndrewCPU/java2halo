package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.IdentifierType;
import net.andrewcpu.halo.type.ScopeType;

public class IISNode <T extends DataType> extends DataNode {
	private T dt;
	public IISNode(String name, T obj) {
		super(name, new DataType[]{new IdentifierType("identifier"), obj, new ScopeType("scope")}, new DataType[]{});
		this.dt = obj;
	}

	public T getDataType() {
		return dt;
	}
}
