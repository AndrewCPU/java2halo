package net.andrewcpu.halo.nodes.nodes.events.inventory.weapons;

import net.andrewcpu.halo.nodes.OutputOnlyNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.GrenadeTypeType;
import net.andrewcpu.halo.type.PlayerType;
import net.andrewcpu.halo.type.VectorType;

public class GrenadePickupEvent extends OutputOnlyNode {
	public GrenadePickupEvent() {
		super("Grenade Pickup Event", new DataType[]{}, new DataType[]{new PlayerType("player"), new GrenadeTypeType("grenadeType"), new VectorType("position")});
	}
}
