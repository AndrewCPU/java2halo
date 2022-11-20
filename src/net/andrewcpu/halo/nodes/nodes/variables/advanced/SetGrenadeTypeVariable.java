package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.GrenadeTypeType;

public class SetGrenadeTypeVariable extends IVSONode<GrenadeTypeType>{
	public SetGrenadeTypeVariable() {
		super("Set Grenade Type Variable", new GrenadeTypeType("value"));
	}
}
