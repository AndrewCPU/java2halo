package net.andrewcpu.halo.nodes.nodes.traits;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.TraitType;

public class TraitMotionTrackerVisible extends DataNode {
	public TraitMotionTrackerVisible () {
		super("Trait: Motion Tracker Visible", new DataType[]{new BooleanType("enabled"), new BooleanType("enabledWhileZooming")}, new DataType[]{new TraitType("trait")});
	}
}
