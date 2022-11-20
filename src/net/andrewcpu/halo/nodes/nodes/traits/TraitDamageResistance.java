package net.andrewcpu.halo.nodes.nodes.traits;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.TraitType;

public class TraitDamageResistance extends DataNode {
	public TraitDamageResistance() { //in direct damage scalar, grenade damage scalar, explosive damage scalar
		super("Trait: Damage Resistance", new DataType[]{new NumberType("direct"), new NumberType("grenade"), new NumberType("explosive")}, new DataType[]{new TraitType("trait")});
	}
}
