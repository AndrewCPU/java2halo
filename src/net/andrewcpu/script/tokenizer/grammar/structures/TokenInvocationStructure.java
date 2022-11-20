package net.andrewcpu.script.tokenizer.grammar.structures;

import net.andrewcpu.script.tokenizer.TokenType;

public class TokenInvocationStructure {
	private Object prefix;
	private ItemList itemList;

	public TokenInvocationStructure(Object prefixToken, ItemList itemList) {
		this.prefix = prefixToken;
		this.itemList = itemList;
	}

	public Object getPrefixToken() {
		return prefix;
	}

	public ItemList getItemList() {
		return itemList;
	}

	@Override
	public String toString() {
		return "TOKEN_INVOCATION[prefix=" + prefix + ", parameters=" + itemList + "]";
	}
}
