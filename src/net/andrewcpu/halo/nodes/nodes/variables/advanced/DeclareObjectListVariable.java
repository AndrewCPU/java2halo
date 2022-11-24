package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.ObjectsType;

public class DeclareObjectListVariable extends IISNode<ObjectsType> {
	public DeclareObjectListVariable() {
		super("Declare Object List Variable.json ", new ObjectsType("initialValue"));
	}
}
