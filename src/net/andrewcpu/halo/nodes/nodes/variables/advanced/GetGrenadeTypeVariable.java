package net.andrewcpu.halo.nodes.nodes.variables.advanced;

import net.andrewcpu.halo.type.GrenadeTypeType;

public class GetGrenadeTypeVariable extends ISONode<GrenadeTypeType> {
	public GetGrenadeTypeVariable() {
		super("Get Grenade Type Variable.json", new GrenadeTypeType("value"));
	}
}
