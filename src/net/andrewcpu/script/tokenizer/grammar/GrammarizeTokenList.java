package net.andrewcpu.script.tokenizer.grammar;

import net.andrewcpu.script.tokenizer.Token;
import net.andrewcpu.script.tokenizer.TokenType;
import net.andrewcpu.script.tokenizer.grammar.structures.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GrammarizeTokenList {

	/**
	 * OK, so how do we want to break these down.
	 * <p>
	 * <p>
	 * <p>
	 * TYPE
	 * OPEN PARENTHESIS
	 * XX
	 * CLOSE PARENTHESIS
	 * <p>
	 * Perhaps we start with parameters?
	 *
	 * @param tokens
	 */
	public static List grammarize(List<Token> tokens) {
		Stack stack = new Stack();
		stack.push(new ArrayList<>());
		//Groups:
		boolean inValueAssignment = false;

		for (Token token : tokens) {
			if (token.getType() == TokenType.OPEN_PARENTHESIS) {
				stack.push(new ArrayList<>());
				stack.peek().add(token);
				stack.push(new ArrayList<>());
			} else if (token.getType() == TokenType.CLOSE_PARENTHESIS) {
				List lastGroup = stack.pop();
				stack.peek().add(lastGroup);
				stack.peek().add(token);
				List list2 = stack.pop();
				stack.peek().add(list2);
			} else if (token.getType() == TokenType.OPEN_CURLY) {
				stack.push(new ArrayList<>());
				stack.peek().add(token);
				stack.push(new ArrayList<>());
			} else if (token.getType() == TokenType.CLOSE_CURLY) {
				List lastGroup = stack.pop();
				stack.peek().add(lastGroup);
				stack.peek().add(token);
				List list2 = stack.pop();
				stack.peek().add(list2);
			}
			else {
				stack.peek().add(token);
			}
		}

		List lists = new ArrayList();
		while (!stack.isEmpty()) {
			lists.add(0, stack.pop());
		}
		lists.forEach(System.out::println);

		List output = (List)recursiveReplacement2(lists);
		for (Object o : output) {
			stack.push((List) o);
		}
		stack.print();
//		printStack(stack);
		return output;
	}

	public static List recursiveReplacement2(List list) {
		List output = new ArrayList();
		boolean changeMade = false;
		for(Object item : list) {
			Object insertingObject = item;
			if(item instanceof List<?> itemList)
			{
				insertingObject = recursiveReplacement2(itemList);
			}
			else if(item instanceof ListStructure structure) {
				Object o = recursiveReplacement2(structure.getChildren());
				structure.setChildren(o instanceof List<?> ? (List)o : List.of(o));
			}

			output.add(insertingObject);

			if(output.size() >= 3) {
				if(output.get(output.size() - 3) instanceof Token tokenA && tokenA.getType() == TokenType.FOREACH) {
					if(output.get(output.size() - 2) instanceof List<?> itemListContainer) {
						if(output.get(output.size() - 1) instanceof List<?> blockContainer) {
							if(itemListContainer.size() > 0 && itemListContainer.get(0) instanceof ItemList itemList) {
								if(blockContainer.size() > 0 && blockContainer.get(0) instanceof BlockStructure blockStructure){
									if(itemList.getChildren().get(0) instanceof List keyValueContainer) {
										if(keyValueContainer.get(0) instanceof ItemList keyValuePair) {
											itemList.getChildren().remove(0);
											if(itemList.getChildren().get(0) instanceof Token tokenB && tokenB.getType() == TokenType.IN){
												itemList.getChildren().remove(0);
												ForEachStructure forEachStructure = new ForEachStructure(keyValuePair, itemList, blockStructure);
												changeMade = true;
												output.remove(output.get(output.size() - 3));
												output.remove(itemListContainer);
												output.remove(blockContainer);
												output.add(forEachStructure);
											}
										}
									}
								}
							}
						}
					}
				}
				if(output.get(output.size() - 3) instanceof Token tokenA && tokenA.getType() == TokenType.IF) {
					if(output.get(output.size() - 2) instanceof List<?> itemListContainer) {
						if(output.get(output.size() - 1) instanceof List<?> blockContainer) {
							if(itemListContainer.size() > 0 && itemListContainer.get(0) instanceof ItemList itemList) {
								if(blockContainer.size() > 0 && blockContainer.get(0) instanceof BlockStructure blockStructure){
									IfStatementStructure ifStatementStructure = new IfStatementStructure(itemList, blockStructure);
									changeMade = true;
									output.remove(output.get(output.size() - 3));
									output.remove(itemListContainer);
									output.remove(blockContainer);
									output.add(ifStatementStructure);
								}
							}
						}
					}
				}
			}
			if(output.size() >= 2){
				if(output.get(output.size() - 2) instanceof Token tokenA && tokenA.getType() == TokenType.ELSE) {
					if(output.get(output.size() - 1) instanceof List<?> itemListContainer) {
						if(itemListContainer.size() > 0 && itemListContainer.get(0) instanceof BlockStructure blockStructure) {
							Token tokenType = (Token) output.remove(output.size() - 2);
							output.remove(output.size() - 1);
							ElseStructure elseStructure = new ElseStructure(tokenType, blockStructure);
							output.add(elseStructure);
							changeMade = true;
						}
					}
					else if(output.get(output.size() - 1) instanceof Token tokenB && tokenB.getType()  == TokenType.STATEMENT_END) {
						Token tokenType = (Token) output.remove(output.size() - 2);
						output.remove(output.size() - 1);
						ElseStructure elseStructure = new ElseStructure(tokenType, new BlockStructure(new ArrayList()));
						output.add(elseStructure);
						changeMade = true;
					}
				}

				if(output.get(output.size() - 2) instanceof Token tokenC && tokenC.getType() == TokenType.NAME || output.get(output.size() - 2) instanceof Token tokenD && tokenD.getType() == TokenType.TYPE) {
					if(output.get(output.size() - 1) instanceof List<?> itemListContainer) {
						if(itemListContainer.size() > 0 && itemListContainer.get(0) instanceof ItemList itemList){
							TokenInvocationStructure tokenInvocationStructure = new TokenInvocationStructure(output.get(output.size() - 2), itemList);
							output.remove((int)(output.size() - 2));
							output.remove(output.size() - 1);
							output.add(tokenInvocationStructure);
							changeMade = true;
						}
					}
				}
			}

			if(output.size() == 3) {
				if(output.get(0) instanceof Token token &&  token.getType() == TokenType.OPEN_PARENTHESIS && output.get(2) instanceof Token tokenB && tokenB.getType() == TokenType.CLOSE_PARENTHESIS){
					if(output.get(1) instanceof List itemList) {
						output = List.of(new ItemList(itemList));
						changeMade = true;
					}
				}
				if(output.get(0) instanceof Token token && token.getType() == TokenType.OPEN_CURLY && output.get(2) instanceof Token tokenB && tokenB.getType() == TokenType.CLOSE_CURLY) {
					if(output.get(1) instanceof List<?> itemList){
						output = List.of(new BlockStructure(itemList));
						changeMade = true;
					}
				}
			}
		}

		for(int i = output.size() - 1; i>= 0; i--){
			if(i - 1 >= 0 && i + 1 <= output.size() - 1){
				if(output.get(i) instanceof Token token && token.getType() == TokenType.ACTION_INVOKATION){
					Object invoking = output.get(i + 1);
					Object invoked = output.get(i - 1);
					ActionInvocation actionInvocation = new ActionInvocation(invoked, invoking);
					output.remove(i + 1);
					output.remove(i);
					output.remove(i - 1);
					output.add(i-1, actionInvocation);
					changeMade = true;
				}
			}
		}
		for(int i = 0; i<output.size(); i++){
			if(i + 3 <= output.size() - 1) {
				if(output.get(i) instanceof Token token && token.getType() == TokenType.NAME) {
					if(output.get(i + 1) instanceof Token equality && equality.getType() == TokenType.ASSIGNMENT_OPERATOR) {
						if(output.get(i + 3) instanceof Token end && end.getType() == TokenType.STATEMENT_END) {
							ValueAssignmentStructure valueAssignmentStructure = new ValueAssignmentStructure(token, output.get(i + 2));
							output.remove( i + 3);
							output.remove( i + 2);
							output.remove(i + 1);
							output.remove(i);
							output.add(i, valueAssignmentStructure);
						}
					}
				}
			}
			if(i + 4 <= output.size() - 1){
				if(output.get(i) instanceof Token token && token.getType() == TokenType.GLOBAL_DECLARATION || output.get(i) instanceof Token token2 && token2.getType() == TokenType.LOCAL_DECLARATION){
					Token scope = (Token) output.get(i);
					if(output.get(i + 1) instanceof Token nameToken && nameToken.getType() == TokenType.NAME){
						Token name = (Token) output.get(i + 1);
						if(output.get(i + 2) instanceof Token valueAssign &&  valueAssign.getType() == TokenType.VALUE_ASSIGNMENT) {
							boolean typed = output.get(i + 3) instanceof Token token && token.getType() == TokenType.TYPE;
							if(output.get(i + 4) instanceof Token endStatement && endStatement.getType() == TokenType.STATEMENT_END) {
								Object  variableDeclarationStructure;
								if(typed) {
									variableDeclarationStructure = new TypedVariableDeclarationStructure(scope, name, (Token)output.get(i + 3));
								}
								else{
									variableDeclarationStructure = new VariableDeclarationStructure(scope, name, output.get(i + 3));
								}
								output.remove(i + 4);
								output.remove( i + 3);
								output.remove( i + 2);
								output.remove(i + 1);
								output.remove(i);
								output.add(i, variableDeclarationStructure);
								changeMade = true;
							}
						}
					}
				}
			}
			if(i + 2 <= output.size() - 1){
				if(output.get(i) instanceof Token eventDeclaration && eventDeclaration.getType() == TokenType.EVENT_DECLARATION) {
					if(output.get(i + 1) instanceof List<?> parameterContainer) {
						if(parameterContainer.size() == 1 && parameterContainer.get(0) instanceof ItemList parameters) {
							if(output.get(i+2) instanceof List<?> blockBody) {
								if(blockBody.get(0) instanceof BlockStructure body) {
									EventDeclarationStructure eventDeclarationStructure = new EventDeclarationStructure((Token) output.get(i), parameters, body);
									output.remove(i + 2);
									output.remove(i + 1);
									output.remove(i);
									output.add(i, eventDeclarationStructure);
									changeMade = true;
								}
							}
						}
					}
				}
			}
			if(i + 1 <= output.size() - 1){
				if(output.get(i) instanceof IfStatementStructure ifStatementStructure){
					if(output.get(i + 1) instanceof ElseStructure elseStructure){
						IfElseStructure ifElseStructure = new IfElseStructure(ifStatementStructure.getIfConditions(), ifStatementStructure.getIfTrue(), elseStructure.getBlock());
						output.remove(i + 1);
						output.remove(i);
						output.add(i, ifElseStructure);
						changeMade = true;
					}
				}
			}
			if(i - 1 >= 0 && i + 1 <= output.size() - 1){
				if(output.get(i) instanceof Token token){
					if(token.getType() == TokenType.BOOLEAN_OPERATOR) {
						BooleanEqualityStructure booleanEqualityStructure = new BooleanEqualityStructure(token, output.get(i - 1), output.get(i + 1));
						output.remove(i + 1);
						output.remove(i);
						output.remove(i - 1);
						output.add(i-1, booleanEqualityStructure);
						i--;
					}
				}
			}
		}

		for(int i = 0; i<output.size(); i++) {
			if(i - 1 >= 0 && i + 1 <= output.size() - 1){
				if(output.get(i) instanceof Token token){
					if(token.getType() == TokenType.BOOLEAN_COMPARISON) {
						BooleanComparisonStructure booleanEqualityStructure = new BooleanComparisonStructure(token, output.get(i - 1), output.get(i + 1));
						output.remove(i + 1);
						output.remove(i);
						output.remove(i - 1);
						output.add(i-1, booleanEqualityStructure);
						i--;
					}
				}
			}
		}

		if(changeMade) return recursiveReplacement2(output);
		return output;
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


	public static void printStack(Stack stack) {
		List<Object> lists = new ArrayList<>();
		lists.add(new ArrayList());
		while (!stack.isEmpty()) {
			List<Object> row = stack.pop();
			lists.add(0, row);
		}
		lists.forEach(System.out::println);
		printList(lists, 0);
	}
}
