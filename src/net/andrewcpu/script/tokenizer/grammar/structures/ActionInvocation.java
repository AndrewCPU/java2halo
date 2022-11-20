package net.andrewcpu.script.tokenizer.grammar.structures;

import net.andrewcpu.script.tokenizer.TokenType;
import net.andrewcpu.script.tokenizer.grammar.GrammarBlock;

import java.util.List;

public class ActionInvocation{
	//Invoking is nested?
	/**
	 *
	 *
	 * name action name action token invocation
	 * invoc(name, null)
	 *
	 * last invoc = (name, name)
	 *
	 * new invoc = ((name, name), null)
	 *
	 * last invoc = ((name, name), token invocation)
	 *
	 * name
	 *      name
	 *          token_invocation
	 */
	private Object base;
	private Object invoking;

	public ActionInvocation(Object base, Object invoking) {
		this.base = base;
		this.invoking = invoking;
	}

	public Object getBase() {
		return base;
	}

	public Object getInvoking() {
		return invoking;
	}

	public void setBase(Object base) {
		this.base = base;
	}

	public void setInvoking(Object invoking) {
		this.invoking = invoking;
	}

	@Override
	public String toString() {
		return "ACTION_INVOCATION_COLLAPSED[base=" + base + ", invoking=" + getInvoking() + "]";
	}


}
