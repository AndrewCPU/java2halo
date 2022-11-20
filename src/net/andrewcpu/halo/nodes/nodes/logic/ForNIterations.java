package net.andrewcpu.halo.nodes.nodes.logic;

import net.andrewcpu.halo.nodes.InputOnlyNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ExecutionThreadType;
import net.andrewcpu.halo.type.NumberType;

public class ForNIterations extends InputOnlyNode {
	public ForNIterations() {
		super("For N Iterations", new DataType[]{new NumberType("iterations")}, new DataType[]{new ExecutionThreadType("onComplete"), new ExecutionThreadType("perIteration"), new NumberType("currentIteration")});
	}

	@Override
	public boolean canCarryLogic() {
		return true;
	}
}
