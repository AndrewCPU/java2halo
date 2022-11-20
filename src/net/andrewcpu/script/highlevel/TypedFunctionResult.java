package net.andrewcpu.script.highlevel;

import net.andrewcpu.halo.type.DataType;

public class TypedFunctionResult<T extends DataType> {

	public static TypedFunctionResult of(DataType type) {
		return new TypedFunctionResult(type, type.getName());
	}
	private T type;
	private String variableName;

	public TypedFunctionResult(T type, String variableName) {
		this.type = type;
		this.variableName = variableName;
	}

	public T getType() {
		return type;
	}

	public String getVariableName() {
		return variableName;
	}
}
