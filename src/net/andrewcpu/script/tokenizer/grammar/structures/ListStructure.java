package net.andrewcpu.script.tokenizer.grammar.structures;

import java.util.List;
import java.util.stream.Collectors;

public abstract class ListStructure {
	public abstract List getChildren();
	public abstract void setChildren(List list);

	@Override
	public String toString() {
		return (String) getChildren().stream().map(child -> ("    " + child.toString())).collect(Collectors.joining("\n"));
	}
}
