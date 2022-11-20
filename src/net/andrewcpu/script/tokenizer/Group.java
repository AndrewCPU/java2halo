package net.andrewcpu.script.tokenizer;

import java.util.List;

public class Group {
	private GroupName groupName;
	private List<Token> tokens;

	public Group(GroupName groupName, List<Token> tokens) {
		this.groupName = groupName;
		this.tokens = tokens;
	}
}
