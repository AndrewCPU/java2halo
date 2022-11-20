package net.andrewcpu.halo.nodes.nodes.logic;

import net.andrewcpu.halo.nodes.InputOnlyNode;
import net.andrewcpu.halo.type.*;

public class ForEachPlayer extends InputOnlyNode {
	public ForEachPlayer() {
		super("For Each Player", new DataType[]{new PlayersType("playerList")}, new DataType[]{new ExecutionThreadType("onComplete"), new ExecutionThreadType("perObject"), new PlayerType("currentPlayer"), new NumberType("currentIteration")});
	}

	@Override
	public boolean canCarryLogic() {
		return true;
	}
}
