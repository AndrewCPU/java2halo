package net.andrewcpu.script;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

public class ScriptingEngine {
	public static void main(String[] args) throws Exception{
		List<String> lines = Files.readAllLines(new File("lang").toPath());

	}
}
