package net.andrewcpu.script.tokenizer.grammar.structures;

import net.andrewcpu.script.tokenizer.Token;
import net.andrewcpu.script.tokenizer.TokenType;

import java.util.List;

public abstract class Structure {
	private List<List<TokenType>> structures;

	public Structure(List<List<TokenType>> structures) {
		this.structures = structures;
	}

	public boolean matches(List<Token> tokens) {
		_outer:
		for(int l = 0; l<structures.size(); l++){
			for(int i = 0; i<structures.get(l).size(); i++){
				if(tokens.get(i).getType() != structures.get(l).get(i)){
					continue _outer;
				}
			}
			return true;
		}
		return false;
	}
}
