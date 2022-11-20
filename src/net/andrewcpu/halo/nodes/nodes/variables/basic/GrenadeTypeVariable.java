package net.andrewcpu.halo.nodes.nodes.variables.basic;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.GrenadeTypeType;

public class GrenadeTypeVariable extends DataNode {
	public GrenadeTypeVariable() {
		super("Grenade Type Variable", new DataType[]{new GrenadeTypeType("value")}, new DataType[]{new GrenadeTypeType("value")});
	}
}
