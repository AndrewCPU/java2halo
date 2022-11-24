package net.andrewcpu.script.tokenizer.grammar.structures;

import net.andrewcpu.script.tokenizer.Token;
import net.andrewcpu.script.tokenizer.TokenType;

import java.util.List;

public class EventDeclarationStructure extends ListStructure{
	private Token eventDeclaration;
	private ItemList parameters;
	private BlockStructure children;

	public EventDeclarationStructure(Token eventDeclaration, ItemList parameters, BlockStructure children) {
		this.eventDeclaration = eventDeclaration;
		this.parameters = parameters;
		this.children = children;
	}

	public Token getEventDeclaration() {
		return eventDeclaration;
	}

	public ItemList getParameters() {
		return parameters;
	}

	public void setParameters(ItemList parameters) {
		this.parameters = parameters;
	}

	public BlockStructure getBody() {
		return  children;
	}

	@Override
	public List getChildren() {
		return List.of(parameters, children);
	}

	@Override
	public void setChildren(List list) {
		this.parameters = (ItemList) list.get(0);
		this.children = (BlockStructure) list.get(1);
	}

	@Override
	public String toString() {
		return "EventDeclarationStructure[" +
				"eventDeclaration=" + eventDeclaration +
				", parameters=" + parameters +
				", children=" + children +
				']';
	}
}
