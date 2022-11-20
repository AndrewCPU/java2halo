package net.andrewcpu.script.parser;

import net.andrewcpu.script.parser.typemap.util.TypeItem;

import java.util.HashMap;

public class Scope {
	private Scope parentScope  = null;
	private HashMap<String, Class<? extends TypeItem>> scope;

	public Scope(Scope parentScope) {
		this.parentScope = parentScope;
		scope = new HashMap<>();
	}

	public Scope() {
		scope = new HashMap<>();
	}

	public void rebind(String name, Class<? extends TypeItem> item) {
		scope.put(name, item);
	}

	public Class<? extends TypeItem> get(String name) {
		return scope.get(name);
	}
}
