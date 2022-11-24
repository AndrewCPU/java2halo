package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.UIMessageType;

public class DeclareUIMessageVariable extends IISNode<UIMessageType> {
	public DeclareUIMessageVariable() {
		super("Declare UI Message Variable.json ", new UIMessageType("initialValue"));
	}
}
