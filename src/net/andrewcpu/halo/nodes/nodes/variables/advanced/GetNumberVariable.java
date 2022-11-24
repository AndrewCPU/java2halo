package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.NumberType;

public class GetNumberVariable extends ISONode<NumberType> {
	public GetNumberVariable() {
		super("Get Number Variable.json", new NumberType("value"));
	}
}
