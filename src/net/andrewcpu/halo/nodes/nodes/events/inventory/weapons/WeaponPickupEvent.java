package net.andrewcpu.halo.nodes.nodes.events.inventory.weapons;

import net.andrewcpu.halo.nodes.OutputOnlyNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;
import net.andrewcpu.halo.type.VectorType;
import net.andrewcpu.halo.type.WeaponType;

public class WeaponPickupEvent extends OutputOnlyNode {
	public WeaponPickupEvent() {
		super("Weapon Pickup Event", new DataType[]{}, new DataType[]{new PlayerType("player"), new WeaponType("weapon"), new VectorType("position")});
	}
}
