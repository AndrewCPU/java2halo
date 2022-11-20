package net.andrewcpu.script.tokenizer.grammar.structures;

import net.andrewcpu.script.tokenizer.TokenType;
import net.andrewcpu.script.tokenizer.grammar.GrammarBlock;
import net.andrewcpu.script.tokenizer.grammar.GrammarBlockType;

import java.util.ArrayList;
import java.util.List;

public class ItemList extends GrammarBlock {
	public ItemList(List children) {
		super(GrammarBlockType.PARAMETER_LIST, (List)children);
	}

	public Object[][] split(TokenType tokenType){
		List<List<Object>> splitting = new ArrayList<>();
		List<Object> current = new ArrayList<>();
		for(Object child : getChildren()) {
			if(child == tokenType) {
				splitting.add(current);
				current = new ArrayList<>();
			}
			current.add(child);
		}
		if(current.size() != 0) {
			splitting.add(current);
		}
		return splitting.stream().map(item -> item.toArray()).toArray(Object[][]::new);
	}

	@Override
	public String toString() {
		return "ITEM_LIST" + getChildren().toString();
	}
}
