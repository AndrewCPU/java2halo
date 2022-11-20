package net.andrewcpu.script.parser.map2node;

import net.andrewcpu.script.tokenizer.grammar.structures.EventDeclarationStructure;
import net.andrewcpu.script.tokenizer.grammar.structures.IfElseStructure;
import net.andrewcpu.script.tokenizer.grammar.structures.ListStructure;

import java.util.List;

public class StructuresToNodes {
	public static void structuresToNodes(List list) {
		// we need to invert almost ALL function calls here.
		/**
		 *  onPlayerKilled(killed, killing, deathContext):
		 *  (
		 *      branch(
		 *          compareTeams(
		 *              getPlayerTeam(killed),
		 *              getPlayerTeam(killer)
		 *          ),
		 *          (ifTrue print(killed))
		 *          (ifFalse (
		 *              blockPlayerRespawns(killed)
		 *              setPlayerTeam(killed, getPlayerTeam(killer))
		 *          ))
		 *      )
		 *
		 *  )
		 *
		 *
		 */
	}
}
