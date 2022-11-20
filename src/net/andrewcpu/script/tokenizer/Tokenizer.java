package net.andrewcpu.script.tokenizer;

import net.andrewcpu.script.parser.GrammarParser;
import net.andrewcpu.script.tokenizer.grammar.GrammarizeTokenList;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tokenizer {

	public static boolean doAnyMatch(String building) {
		for(TokenType tokenType : TokenType.values()) {
			if(tokenType.matches(building)){
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) throws Exception{
		List<String> lines = Files.readAllLines(new File("lang").toPath());
		lines = lines.stream().map(line -> line.replaceAll("[()]"," $0 ").replaceAll("[{}]", " $0 ").replaceAll(",", " , ").replaceAll(":", " : ").replaceAll(";", " ; ").replaceAll("([A-Za-z ])[.]([A-Za-z])", "$1 . $2").replaceAll("\\h{2,}", " ").trim()).collect(Collectors.toList());
		lines.forEach(System.out::println);
		List<Token> tokens = new ArrayList<>();
		for(String line : lines) {
			if(line.length() == 0) continue;
			String[] groups = line.split(" ");
			for(String group : groups) {
				if(group.length() == 0)  continue;
				TokenType type = TokenType.getFirstMatch(group);
				tokens.add(new Token(type, group));
			}
		}
		tokens.forEach(System.out::println);
		List structured = GrammarizeTokenList.grammarize(tokens);
		GrammarParser.parse(structured);

	}
}
