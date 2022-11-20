package net.andrewcpu.halo.nodes.nodes.inventory.equipment;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;

public class RefillDefaultGrenades extends IONode {
	public RefillDefaultGrenades() {
		super("Refill Default Grenades", new DataType[]{new PlayerType("player")}, new DataType[]{});
	}
}
