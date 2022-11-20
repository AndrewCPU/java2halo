package net.andrewcpu.script.parser;

import net.andrewcpu.halo.nodes.AllNodes;
import net.andrewcpu.halo.nodes.Node;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.script.parser.map2node.StructuresToNodes;
import net.andrewcpu.script.parser.typemap.Player;
import net.andrewcpu.script.parser.typemap.Team;
import net.andrewcpu.script.parser.typemap.event_types.PlayerKilledEvent;
import net.andrewcpu.script.parser.typemap.util.DataTypeToElement;
import net.andrewcpu.script.parser.typemap.util.TypeItem;
import net.andrewcpu.script.tokenizer.Token;
import net.andrewcpu.script.tokenizer.TokenType;
import net.andrewcpu.script.tokenizer.grammar.structures.ActionInvocation;
import net.andrewcpu.script.tokenizer.grammar.structures.EventDeclarationStructure;
import net.andrewcpu.script.tokenizer.grammar.structures.TokenInvocationStructure;
import net.andrewcpu.script.tokenizer.grammar.structures.VariableDeclarationStructure;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GrammarParser {

	public static void parse(List list) {
		IntStream.range(0, 50).mapToObj(i-> "").forEach(System.out::println);
		StructuresToNodes.structuresToNodes(list);
		for (Object row : list) {
//			parseList(globalScope, row);
		}
	}

	public static HashMap<String, DataType> getEventOutputs(String eventName) {
		Class c = AllNodes.getEventDeclarations().stream().filter(event->event.getClass().getSimpleName().startsWith(eventName)).collect(Collectors.toList()).get(0);
		try {
			Node node = (Node)(c.getConstructors()[0].newInstance());
			HashMap<String, DataType> output = new HashMap<>();
			for(DataType type : node.getOutputs()) {
				output.put(type.getName(), type);
			}
			return output;
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	public static HashMap<String, HashMap> variableDeclarations = new HashMap<>();


	public static Class<TypeItem>[] typeItems = new Class[]{
			Player.class,
			Team.class,
			PlayerKilledEvent.class
	};

	public static Class<TypeItem> getTypeFor(String name) {
		for(Class<TypeItem> itemClass : typeItems) {
			if(itemClass.getSimpleName().equalsIgnoreCase(name)) {
				return itemClass;
			}
		}
		return null;
	}

	private static Scope globalScope = new Scope();

	public static DataType doesNameExistInClass(Class<? extends TypeItem> item, String name) {
		List<Class> results =  Arrays.stream(item.getDeclaredMethods()).filter(method -> method.getName().equalsIgnoreCase(name)).map(method -> method.getReturnType().getClass()).collect(Collectors.toList());
		DataType result = null;
		for(Method method : item.getDeclaredMethods()) {
			if(method.getName().equals(name)){
				if(Modifier.isAbstract(method.getModifiers())) {
					try {
						result = (DataType)method.getReturnType().getConstructors()[0].newInstance(name);
					} catch (InstantiationException e) {
						throw new RuntimeException(e);
					} catch (IllegalAccessException e) {
						throw new RuntimeException(e);
					} catch (InvocationTargetException e) {
						throw new RuntimeException(e);
					}
					break;
				}
			}
		}


		return result;
	}

	public static DataType getType(Class<? extends TypeItem> item, Scope scope, ActionInvocation actionInvocation) {
		Class<? extends TypeItem> base = null;
		if(actionInvocation.getBase() instanceof Token token){
			if(token.getType() == TokenType.NAME) {
				if(scope.get(token.getValue()) != null){
					base = scope.get(token.getValue());
					System.out.println(base);
				}
				else {
					DataType dataType = doesNameExistInClass(item, token.getValue());
					if (dataType != null) {
						base = DataTypeToElement.fromType(dataType.getClass());
						System.out.println(base);
					} else {
						System.out.println("COULDNT FIND IN CHILD");
						return null;
					}
				}
			}
		}
		else if(actionInvocation.getBase() instanceof ActionInvocation invoking) {
			return getType(item, scope,invoking);
		}
		else if(actionInvocation.getBase() instanceof TokenInvocationStructure tokenInvocationStructure) {
			if(tokenInvocationStructure.getPrefixToken() instanceof Token token){
				if(token.getType() == TokenType.NAME) {
					if(scope.get(token.getValue()) != null){
						base = scope.get(token.getValue());
						System.out.println(base);
					}
					else {
						DataType dataType = doesNameExistInClass(item, token.getValue());
						if (dataType != null) {
							base = DataTypeToElement.fromType(dataType.getClass());
							System.out.println(base);
						} else {
							System.out.println("COULDNT FIND IN CHILD ??");
							return null;
						}
					}
				}
			}
		}

		if(actionInvocation.getInvoking() instanceof ActionInvocation i2) {
			return getType(base,scope, i2);
		}
		if(actionInvocation.getInvoking() instanceof TokenInvocationStructure tokenInvocationStructure) {
			DataType dataType = doesNameExistInClass(base, ((Token)tokenInvocationStructure.getPrefixToken()).getValue());
			System.out.println("Looking for " + ((Token)tokenInvocationStructure.getPrefixToken()).getValue() + " in " + base);
			if (dataType != null) {
				return dataType;
//				base = DataTypeToElement.fromType(dataType.getClass());
//				System.out.println(base);
			} else {
				System.out.println("COULDNT FIND IN CHILD ");
				return null;
			}
		}

		return null;
	}

	public static void parseList(Scope inScope, Object object) {
		if(!(object instanceof List<?>)){
			return;
		}
		List list = (List) object;

		for(Object child : list) {
			if(child instanceof EventDeclarationStructure eventDeclarationStructure) {
				String eventName = eventDeclarationStructure.getEventDeclaration().getValue().substring(1);
				Scope scope = new Scope(inScope);
				scope.rebind(((Token)eventDeclarationStructure.getParameters().getChildren().get(0)).getValue(), getTypeFor(eventName));
				parseList(scope, eventDeclarationStructure.getBody().getChildren());
			}
			if(child instanceof ActionInvocation actionInvocation) {
				DataType result= getType(PlayerKilledEvent.class, inScope, actionInvocation);
				System.out.println(result.getClass().getSimpleName());
			}
		}

	}

}
