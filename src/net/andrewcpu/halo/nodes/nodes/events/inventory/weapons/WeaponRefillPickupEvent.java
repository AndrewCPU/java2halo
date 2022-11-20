package net.andrewcpu.halo.nodes.nodes.events.inventory.weapons;

import net.andrewcpu.halo.nodes.OutputOnlyNode;
import net.andrewcpu.halo.type.*;

public class WeaponRefillPickupEvent extends OutputOnlyNode {
	public WeaponRefillPickupEvent() {
		super("Weapon Refill Pickup Event", new DataType[]{}, new DataType[]{new PlayerType("player"), new WeaponType("weapon"),new VectorType("position"), new BooleanType("didFinish")});
	}
}
