package net.andrewcpu.script.tokenizer.grammar.structures;

import java.util.List;
import java.util.stream.Collectors;

public class BlockStructure extends ListStructure{
	private List children;
	public BlockStructure(List children){
		this.children = children;
	}

	@Override
	public List getChildren() {
		return children;
	}

	@Override
	public void setChildren(List list) {
		this.children = list;
	}

	@Override
	public String toString() {
		return "BLOCK START" + getChildren().toString() + "BLOCK END";
	}
}
