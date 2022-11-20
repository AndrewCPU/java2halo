package net.andrewcpu.script.tokenizer.grammar;

import net.andrewcpu.script.tokenizer.grammar.structures.ListStructure;

import java.util.List;

public class GrammarBlock extends ListStructure {
	private GrammarBlockType type;
	private List children;

	public GrammarBlock(GrammarBlockType type, List children) {
		this.type = type;
		this.children = children;
	}


	public GrammarBlockType getType() {
		return type;
	}

	public List getChildren() {
		return children;
	}

	public void setChildren(List children) {
		this.children = children;
	}
}
