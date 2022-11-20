package net.andrewcpu.halo.nodes.nodes.inventory.equipment;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.GrenadeTypeType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.PlayerType;

public class AdjustPlayerGrenades extends IONode {
	public AdjustPlayerGrenades() {
		super("Adjust Player Grenades", new DataType[]{new PlayerType("player"), new GrenadeTypeType("grenadeType"), new NumberType("adjustment")}, new DataType[]{});
	}
}
