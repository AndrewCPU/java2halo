package net.andrewcpu.halo.nodes.nodes.traits;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.TraitType;

public class TraitMotionTrackerRange extends DataNode {
	public TraitMotionTrackerRange () {
		super("Trait: Motion Tracker Range", new DataType[]{new NumberType("innerRange"), new NumberType("extendedRange"), new NumberType("vehicleRange")}, new DataType[]{new TraitType("trait")});
	}
}
