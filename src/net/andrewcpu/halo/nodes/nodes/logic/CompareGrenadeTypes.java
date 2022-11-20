package net.andrewcpu.halo.nodes.nodes.logic;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.GrenadeTypeType;

public class CompareGrenadeTypes extends DataNode {
	public CompareGrenadeTypes() {
		super("Compare Grenade Types", new DataType[]{new GrenadeTypeType("a"), new GrenadeTypeType("b")}, new DataType[]{new BooleanType("equal")});
	}
}
