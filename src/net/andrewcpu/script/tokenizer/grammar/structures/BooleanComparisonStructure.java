package net.andrewcpu.script.tokenizer.grammar.structures;

import net.andrewcpu.script.tokenizer.Token;
import net.andrewcpu.script.tokenizer.TokenType;

import java.util.List;

public class BooleanComparisonStructure extends ListStructure {
	private Token comparisonOperator;
	private Object left;
	private Object right;

	public BooleanComparisonStructure(Token comparisonOperator, Object left, Object right) {
		this.comparisonOperator = comparisonOperator;
		this.left = left;
		this.right = right;
	}

	@Override
	public List getChildren() {
		return List.of(left,comparisonOperator, right);
	}

	@Override
	public void setChildren(List list) {
		this.left = list.get(0);
		this.comparisonOperator = (Token)list.get(1);
		this.right = list.get(2);
	}
}
