package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.UIMessageType;

public class SetUIMessageVariable extends IVSONode<UIMessageType>{
	public SetUIMessageVariable() {
		super("Set UI Message Variable.json", new UIMessageType("value"));
	}
}
