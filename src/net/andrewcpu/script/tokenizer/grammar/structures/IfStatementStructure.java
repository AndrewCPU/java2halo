package net.andrewcpu.script.tokenizer.grammar.structures;

import java.util.List;

public class IfStatementStructure extends ListStructure{

	private ItemList ifConditions;
	private BlockStructure ifTrue;

	public IfStatementStructure(ItemList ifConditions, BlockStructure ifTrue) {
		this.ifConditions = ifConditions;
		this.ifTrue = ifTrue;
	}

	public ItemList getIfConditions() {
		return ifConditions;
	}

	public BlockStructure getIfTrue() {
		return ifTrue;
	}

	@Override
	public List getChildren() {
		return List.of(ifConditions, ifTrue);
	}

	@Override
	public void setChildren(List list) {
		ifConditions = (ItemList) list.get(0);
		ifTrue = (BlockStructure) list.get(1);
	}

	@Override
	public String toString() {
		return "IF[condition=" + ifConditions + ", ifTrue=" + ifTrue + "]";
	}
}
