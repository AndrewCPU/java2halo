package net.andrewcpu.halo.nodes.nodes.traits;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.TraitType;

public class TraitShieldRecharge extends DataNode {
	public TraitShieldRecharge () { // delay, rate scalar
		super("Trait: Shield Recharge", new DataType[]{new NumberType("delay"), new NumberType("rate")}, new DataType[]{new TraitType("trait")});
	}
}
