package net.andrewcpu.script.highlevel;

import net.andrewcpu.halo.nodes.Node;
import net.andrewcpu.halo.type.DataType;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class SimpleNodeBundle<T extends DataType, Q extends Node> extends NodeBundle{
	private int prefillIndex, outputIndex;
	private TypedFunctionResult[] functionResults;
	private TypedFunctionResult[] functionInputs;

	public SimpleNodeBundle(Class<Q> node, int prefillIndex, int outputIndex) {
		this.prefillIndex = prefillIndex;
		this.outputIndex = outputIndex;
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
	public SimpleNodeBundle(Class<Q> node, int prefillIndex) {
		this.prefillIndex = prefillIndex;
		this.outputIndex = 0;
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

	public TypedFunctionResult getFunctionResult() {
		return functionResults[outputIndex];
	}

	public TypedFunctionResult[] getFunctionInputs() {
		return functionInputs;
	}
}
