package net.andrewcpu.halo.nodes.nodes.logic;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;

public class BooleanLogic extends DataNode {
	public BooleanLogic() {
		super("Boolean Logic", new DataType[]{new BooleanType("a"), new BooleanType("b")}, new DataType[]{new BooleanType("and"), new BooleanType("or")});
	}
}
