package net.andrewcpu.halo.nodes.nodes.events.inventory.weapons;

import net.andrewcpu.halo.nodes.OutputOnlyNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;
import net.andrewcpu.halo.type.WeaponType;

public class WeaponAddedEvent extends OutputOnlyNode {
	public WeaponAddedEvent() {
		super("Weapon Added Event", new DataType[]{}, new DataType[]{new PlayerType("player"), new WeaponType("weapon")});
	}
}
