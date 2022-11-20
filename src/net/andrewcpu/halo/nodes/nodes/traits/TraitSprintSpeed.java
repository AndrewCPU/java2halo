package net.andrewcpu.halo.nodes.nodes.traits;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.TraitType;

public class TraitSprintSpeed extends DataNode {
	public TraitSprintSpeed () { // top speed, time to top speed
		super("Trait: Sprint Speed", new DataType[]{new NumberType("speed"), new NumberType("duration")}, new DataType[]{new TraitType("trait")});
	}
}
