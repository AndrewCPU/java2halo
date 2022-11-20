package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.GrenadeTypeType;

public class DeclareGrenadeTypeVariable extends IISNode<GrenadeTypeType> {
	public DeclareGrenadeTypeVariable() {
		super("Declare Grenade Type Variable ", new GrenadeTypeType("initialValue"));
	}
}
