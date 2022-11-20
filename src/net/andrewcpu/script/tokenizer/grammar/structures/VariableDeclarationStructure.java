package net.andrewcpu.script.tokenizer.grammar.structures;

import net.andrewcpu.script.tokenizer.Token;
import net.andrewcpu.script.tokenizer.TokenType;

import java.util.List;

public class VariableDeclarationStructure{
	private Token declarationScope;
	private Token name;
	private Object value;

	public VariableDeclarationStructure(Token declarationScope, Token name, Object value) {
		this.declarationScope = declarationScope;
		this.name = name;
		this.value = value;
	}

	@Override
	public String toString() {
		return "VARIABLE[scope=" + declarationScope + ", name=" + name + ", value=" + value.toString() + "]";
	}

	public Object getValue() {
		return value;
	}

	public Token getDeclarationScope() {
		return declarationScope;
	}

	public Token getName() {
		return name;
	}
}
