package net.andrewcpu.script.tokenizer.grammar.structures;

import net.andrewcpu.script.tokenizer.Token;

public class TypedVariableDeclarationStructure {
	private Token declarationScope;
	private Token name;
	private Token type;

	public TypedVariableDeclarationStructure(Token declarationScope, Token name, Token type) {
		this.declarationScope = declarationScope;
		this.name = name;
		this.type = type;
	}

	@Override
	public String toString() {
		return "TYPED_VARIABLE[scope=" + declarationScope + ", name=" + name + ", type=" + type.toString() + "]";
	}

	public Token getValue() {
		return type;
	}

	public Token getDeclarationScope() {
		return declarationScope;
	}

	public Token getName() {
		return name;
	}
}
