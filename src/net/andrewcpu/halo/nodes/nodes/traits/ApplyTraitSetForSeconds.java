package net.andrewcpu.halo.nodes.nodes.traits;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.IdentifierType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.PlayerType;

public class ApplyTraitSetForSeconds extends IONode {
	public ApplyTraitSetForSeconds() {
		super("Apply Trait Set for Seconds", new DataType[]{new IdentifierType("identifier"), new PlayerType("player"), new NumberType("seconds")}, new DataType[]{});
	}
}
