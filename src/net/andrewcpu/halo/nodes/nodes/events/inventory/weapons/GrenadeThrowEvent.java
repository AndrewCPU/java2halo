package net.andrewcpu.halo.nodes.nodes.events.inventory.weapons;

import net.andrewcpu.halo.nodes.OutputOnlyNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.GrenadeTypeType;
import net.andrewcpu.halo.type.PlayerType;

public class GrenadeThrowEvent extends OutputOnlyNode {
	public GrenadeThrowEvent() {
		super("Grenade Throw Event", new DataType[]{}, new DataType[]{new PlayerType("player"), new GrenadeTypeType("grenadeType")});
	}
}
