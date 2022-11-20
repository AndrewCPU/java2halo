package net.andrewcpu.halo.nodes.nodes.traits;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.TraitType;

public class TraitHealthRecharge extends DataNode {
	public TraitHealthRecharge () { // delay scalar, rate scalar
		super("Trait: Health Recharge", new DataType[]{new NumberType("delay"), new NumberType("rate")}, new DataType[]{new TraitType("trait")});
	}
}
