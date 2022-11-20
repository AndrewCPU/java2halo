package net.andrewcpu.script.highlevel;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.nodes.Node;
import net.andrewcpu.halo.type.DataType;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ComplexNodeBundle<Q extends Node> extends NodeBundle{

	private int prefillIndex;
	private TypedFunctionResult[] functionResults;
	private TypedFunctionResult[] functionInputs;
	public ComplexNodeBundle(Class<Q> node, int prefillIndex) {
		this.prefillIndex = prefillIndex;
		try {
			functionResults = Arrays.stream(((Node)node.getConstructors()[0].newInstance()).getOutputs()).map(dataType -> new TypedFunctionResult(dataType, dataType.getName())).toArray(TypedFunctionResult[]::new);
			functionInputs = Arrays.stream(((Node)node.getConstructors()[0].newInstance()).getInputs()).map(dataType -> new TypedFunctionResult(dataType, dataType.getName())).toArray(TypedFunctionResult[]::new);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	public TypedFunctionResult[] getFunctionResults() {
		return functionResults;
	}

	public TypedFunctionResult[] getFunctionInputs() {
		return functionInputs;
	}

	// a complex node bundle is a method of declaring which nodes compose a high level type
	// it also indicates how to fill in said nodes with a predefined value.
}
