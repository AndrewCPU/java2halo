package net.andrewcpu.halo.nodes.nodes.variables.basic;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.IdentifierType;
import net.andrewcpu.halo.type.StringType;

public class IdentifierVariable extends DataNode {
	public IdentifierVariable() {
		super("Identifier Variable.json", new DataType[]{new StringType("value")}, new DataType[]{new IdentifierType("identifier")});
	}
}
