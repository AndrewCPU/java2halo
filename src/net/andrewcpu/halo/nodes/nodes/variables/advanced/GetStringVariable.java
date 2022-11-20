package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.StringType;

public class GetStringVariable extends ISONode<StringType> {
	public GetStringVariable() {
		super("Get String Variable", new StringType("value"));
	}
}
