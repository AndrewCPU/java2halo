package net.andrewcpu.script.parser.typemap.util;

import net.andrewcpu.halo.type.DataType;

public class NamedResult<T extends DataType> {
	private String name;
	private Class<T> type;
	public NamedResult(String name, Class<T> type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public Class<T> getType() {
		return type;
	}
}
