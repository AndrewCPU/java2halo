package net.andrewcpu.script.tokenizer.grammar.structures;

import java.util.List;

public class IfElseStructure extends ListStructure{
	private ItemList ifConditions;
	private BlockStructure ifTrue;
	private BlockStructure ifFalse;

	public IfElseStructure(ItemList ifConditions, BlockStructure ifTrue, BlockStructure ifFalse) {
		this.ifConditions = ifConditions;
		this.ifTrue = ifTrue;
		this.ifFalse = ifFalse;
	}

	public ItemList getIfConditions() {
		return ifConditions;
	}

	public BlockStructure getIfTrue() {
		return ifTrue;
	}

	public BlockStructure getIfFalse() {
		return ifFalse;
	}

	@Override
	public List getChildren() {
		return List.of(ifConditions, ifTrue, ifFalse);
	}

	@Override
	public void setChildren(List list) {
		this.ifConditions = (ItemList) list.get(0);
		this.ifTrue = (BlockStructure) list.get(1);
		this.ifFalse = (BlockStructure) list.get(2);
	}
}
