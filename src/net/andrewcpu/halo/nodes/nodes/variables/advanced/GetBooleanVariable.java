package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.BooleanType;

public class GetBooleanVariable extends ISONode<BooleanType>{
	public GetBooleanVariable() {
		super("Get Boolean Variable.json", new BooleanType("value"));
	}
}
