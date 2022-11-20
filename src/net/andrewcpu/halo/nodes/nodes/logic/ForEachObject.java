package net.andrewcpu.halo.nodes.nodes.logic;

import net.andrewcpu.halo.nodes.InputOnlyNode;
import net.andrewcpu.halo.type.*;

public class ForEachObject extends InputOnlyNode {
	public ForEachObject() {
		super("For Each Object", new DataType[]{new ObjectsType("objectList")}, new DataType[]{new ExecutionThreadType("onComplete"), new ExecutionThreadType("perObject"), new ObjectType("currentObject"), new NumberType("currentIteration")});
	}

	@Override
	public boolean canCarryLogic() {
		return true;
	}
}
