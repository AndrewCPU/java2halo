package net.andrewcpu.halo.nodes.nodes.traits;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.TraitType;

public class TraitVamporism extends DataNode {
	public TraitVamporism () {
		super("Trait: Vamporism", new DataType[]{new NumberType("shield"), new NumberType("health")}, new DataType[]{new TraitType("trait")});
	}
}
