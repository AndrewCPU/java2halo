package net.andrewcpu.script.tokenizer.grammar.structures;

import net.andrewcpu.script.tokenizer.Token;

import java.util.List;

public class BooleanEqualityStructure extends ListStructure {
	private Token comparisonOperator;
	private Object left;
	private Object right;

	public BooleanEqualityStructure(Token comparisonOperator, Object left, Object right) {
		this.comparisonOperator = comparisonOperator;
		this.left = left;
		this.right = right;
	}

	@Override
	public List getChildren() {
		return List.of(comparisonOperator, left, right);
	}

	@Override
	public void setChildren(List list) {
		this.left = list.get(1);
		this.comparisonOperator = (Token)list.get(0);
		this.right = list.get(2);
	}

	@Override
	public String toString() {
		return "BooleanEqualityStructure[" +
				"comparisonOperator=" + comparisonOperator +
				", left=" + left +
				", right=" + right +
				']';
	}

	public Token getComparisonOperator() {
		return comparisonOperator;
	}

	public void setComparisonOperator(Token comparisonOperator) {
		this.comparisonOperator = comparisonOperator;
	}

	public Object getLeft() {
		return left;
	}

	public void setLeft(Object left) {
		this.left = left;
	}

	public Object getRight() {
		return right;
	}

	public void setRight(Object right) {
		this.right = right;
	}
}
