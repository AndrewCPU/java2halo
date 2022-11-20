package net.andrewcpu.halo.nodes.nodes.traits;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.IdentifierType;
import net.andrewcpu.halo.type.PlayerType;

public class ApplyTraitSetUntilDeath extends IONode {
	public ApplyTraitSetUntilDeath() {
		super("Apply Trait Set Until Death", new DataType[]{new IdentifierType("identifier"), new PlayerType("player")}, new DataType[]{});
	}
}
