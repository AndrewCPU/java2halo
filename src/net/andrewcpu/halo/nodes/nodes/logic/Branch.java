package net.andrewcpu.halo.nodes.nodes.logic;

import net.andrewcpu.halo.nodes.InputOnlyNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ExecutionThreadType;

public class Branch extends InputOnlyNode {
	public Branch() {
		super("Branch", new DataType[]{new BooleanType("condition")}, new DataType[]{new ExecutionThreadType("ifTrue"), new ExecutionThreadType("ifFalse")});
	}

	@Override
	public boolean canCarryLogic() {
		return true;
	}
}
