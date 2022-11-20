package net.andrewcpu.script.parser.typemap.util;

public class MultiResponseType {

	public MultiResponseType(NamedResult... responseType) {
		this.results = responseType;
	}

	private NamedResult[] results;

	public NamedResult[] getResults() {
		return results;
	}
}
