package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.UIMessageType;

public class GetUIMessageVariable extends ISONode<UIMessageType> {
	public GetUIMessageVariable() {
		super("Get UI Message Variable.json", new UIMessageType("value"));
	}
}
