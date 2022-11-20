package net.andrewcpu.halo.nodes.nodes.traits;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.TraitType;

public class TraitVFXActiveCamo extends DataNode {

	public TraitVFXActiveCamo () { // intensity, interpolation
		super("Trait: VFX Active Camo", new DataType[]{new NumberType("intensity"), new NumberType("interpolation")}, new DataType[]{new TraitType("trait")});
	}

}
