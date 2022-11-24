package net.andrewcpu.script.tokenizer;

public enum TokenType {
	GLOBAL_DECLARATION("global|bind"),
	LOCAL_DECLARATION("local"),
	EMPTY("empty"),
//	PARAMETER,
	IF("if"),
	ELSE("else"),
	FOREACH("foreach"),
	NUMBER_ASSIGNMENT("\\d+(\\.\\d+)?"),
	VALUE_ASSIGNMENT("[:]"),
	ASSIGNMENT_OPERATOR("="),
	STATEMENT_END("[;]"),
	EVENT_DECLARATION("@[\\w]+"),
	IN("in"),
	BOOLEAN_OPERATOR("==|>|<"),
	BOOLEAN_COMPARISON("&&|\\|\\|"),
	BOOLEAN_VALUE("true|false"),
	OPEN_PARENTHESIS("[(]"),
	CLOSE_PARENTHESIS("[)]"),
	OPEN_CURLY("[{]"),
	CLOSE_CURLY("[}]"),
	ACTION_INVOKATION("[.]"),
	LIST_SEPARATOR("[,]"),
	TYPE(""),
	NAME(""),
	UNKNOWN("erwer wer wer ");
	private final String regex;

	@Override
	public String toString() {
		return this.name();
	}

	TokenType(String regex) {
		this.regex = regex;
	}

	public String getRegex() {
		if(this == TYPE) {
			return "[A-Z][A-z]+";
		}
		else if(this == NAME) {
			return "[A-Za-z0-9]+";
		}
		return regex;
	}
	public static TokenType getFirstMatch(String text) {
		for(TokenType type : values()){
			if(type.matches(text)){
				return type;
			}
		}
		System.out.println("UNKNOWN ?? " + text);
		return TokenType.UNKNOWN;
	}
	public boolean matches(String text) {
		return text.matches(getRegex());
	}
}
