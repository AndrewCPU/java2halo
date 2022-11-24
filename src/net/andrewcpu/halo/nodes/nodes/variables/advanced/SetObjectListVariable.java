package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.ObjectsType;

public class SetObjectListVariable extends IVSONode<ObjectsType>{
	public SetObjectListVariable() {
		super("Set Object List Variable.json", new ObjectsType("value"));
	}
}
