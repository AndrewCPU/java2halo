package net.andrewcpu.script.tokenizer.grammar.structures;

import java.util.List;

public class ForEachStructure extends ListStructure{
	private List children;
	public ForEachStructure(ItemList keyValuePair, ItemList parameters, BlockStructure child) {
		children = List.of(keyValuePair, parameters, child);
	}
	@Override
	public List getChildren() {
		return children;
	}

	@Override
	public void setChildren(List list) {
		children = list;
	}

	@Override
	public String toString() {
		return "ForEach[key_value_pair=" + children.get(0)  + ", iterating=" + children.get(1) + ", block=" + children.get(2) + "]";
	}
}
