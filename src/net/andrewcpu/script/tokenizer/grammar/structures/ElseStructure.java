package net.andrewcpu.script.tokenizer.grammar.structures;

import net.andrewcpu.script.tokenizer.Token;
import net.andrewcpu.script.tokenizer.TokenType;

import java.util.List;

public class ElseStructure extends ListStructure{
	private Token token;
	private BlockStructure block;

	public ElseStructure(Token token, BlockStructure block) {
		this.token = token;
		this.block = block;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public BlockStructure getBlock() {
		return block;
	}

	public void setBlock(BlockStructure block) {
		this.block = block;
	}

	@Override
	public List getChildren() {
		return block.getChildren();
	}

	@Override
	public void setChildren(List list) {
		block.setChildren(list);
	}

	@Override
	public String toString() {
		return "ELSE[body=" + block + "]";
	}
}
