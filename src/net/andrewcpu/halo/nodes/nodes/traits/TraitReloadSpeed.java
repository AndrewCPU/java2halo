package net.andrewcpu.halo.nodes.nodes.traits;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.TraitType;

public class TraitReloadSpeed extends DataNode {
	public TraitReloadSpeed () {
		super("Trait: Reload Speed", new DataType[]{new NumberType("empty"), new NumberType("tactical")}, new DataType[]{new TraitType("trait")});
	}
}
