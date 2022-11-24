package net.andrewcpu.script.tokenizer.grammar;

import net.andrewcpu.script.tokenizer.Token;
import net.andrewcpu.script.tokenizer.TokenType;
import net.andrewcpu.script.tokenizer.grammar.structures.*;

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

	public static void printList(List<Object> objects, int n) {
		if (objects.size() == 0) {
			System.out.printf("%-" + ((n - 1) * 4 + 1) + "s", "");
			System.out.println("!!EMPTY LIST!!");
			return;
		}
		for (Object object : objects) {
			if (object instanceof List<?>) {
				printList((List) object, n + 1);
			} else if (object instanceof Enum<?>) {
				System.out.printf("%-" + ((n - 1) * 4 + 1) + "s", "");
				System.out.print(((Enum) object).name() + "\n");
			} else if (object instanceof BlockStructure) {
				System.out.printf("%-" + ((n - 1) * 4 + 1) + "s", "");
				System.out.print((object.getClass().getSimpleName()) + " START\n");
				printList((((ListStructure) object).getChildren()), n + 1);
				System.out.printf("%-" + ((n - 1) * 4 + 1) + "s", "");
				System.out.print((object.getClass().getSimpleName()) + " END\n");
			}
			else if(object instanceof IfStatementStructure){
				System.out.printf("%-" + ((n - 1) * 4 + 1) + "s", "");
				System.out.print((object.getClass().getSimpleName()) + " START\n");
				printList((((ListStructure) object).getChildren()), n + 1);
				System.out.printf("%-" + ((n - 1) * 4 + 1) + "s", "");
				System.out.print((object.getClass().getSimpleName()) + " END\n");
			}
			else if(object instanceof ElseStructure){
				System.out.printf("%-" + ((n - 1) * 4 + 1) + "s", "");
				System.out.print((object.getClass().getSimpleName()) + " START\n");
				printList((((ListStructure) object).getChildren()), n + 1);
				System.out.printf("%-" + ((n - 1) * 4 + 1) + "s", "");
				System.out.print((object.getClass().getSimpleName()) + " END\n");
			}
			else if(object instanceof IfElseStructure){
				System.out.printf("%-" + ((n - 1) * 4 + 1) + "s", "");
				System.out.print((object.getClass().getSimpleName()) + " START\n");
				printList((((ListStructure) object).getChildren()), n + 1);
				System.out.printf("%-" + ((n - 1) * 4 + 1) + "s", "");
				System.out.print((object.getClass().getSimpleName()) + " END\n");
			}
			else if(object instanceof ForEachStructure){
				System.out.printf("%-" + ((n - 1) * 4 + 1) + "s", "");
				System.out.print((object.getClass().getSimpleName()) + " START\n");
				printList((((ListStructure) object).getChildren()), n + 1);
				System.out.printf("%-" + ((n - 1) * 4 + 1) + "s", "");
				System.out.print((object.getClass().getSimpleName()) + " END\n");
			}
			else if(object instanceof EventDeclarationStructure){
				System.out.printf("%-" + ((n - 1) * 4 + 1) + "s", "");
				System.out.print((object.getClass().getSimpleName()) + " START\n");
				printList((((ListStructure) object).getChildren()), n + 1);
				System.out.printf("%-" + ((n - 1) * 4 + 1) + "s", "");
				System.out.print((object.getClass().getSimpleName()) + " END\n");
			}
			else {
				System.out.printf("%-" + ((n - 1) * 4 + 1) + "s", "");
				System.out.print((object).toString() + "\n");
			}
		}
	}

	public void print() {
		for(List list : stack) {
			printList(list, 1);
		}
	}

}
