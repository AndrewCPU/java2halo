package net.andrewcpu.script.tokenizer.grammar;

import net.andrewcpu.script.tokenizer.Token;
import net.andrewcpu.script.tokenizer.TokenType;

import java.util.ArrayList;
import java.util.List;

public class Stack {
	private List<List<Object>> stack = new ArrayList<>();
	public Stack(){
		stack.add(new ArrayList<>());
	}

	public void push(List<Object> entry) {
		stack.add(entry);
	}

	public List<Object> pop() {
		return stack.remove(stack.size() - 1);
	}

	public List<Object> peek() {
		return stack.get(stack.size() - 1);
	}

	public int size() {
		return stack.size();
	}

	public boolean isEmpty(){
		return stack.size() == 0;
	}

	public List collapse() {
		return stack;
	}
}
