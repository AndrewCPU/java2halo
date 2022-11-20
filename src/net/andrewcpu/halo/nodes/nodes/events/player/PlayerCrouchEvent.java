package net.andrewcpu.halo.nodes.nodes.events.player;

import net.andrewcpu.halo.nodes.OutputOnlyNode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;

public class PlayerCrouchEvent extends OutputOnlyNode {
	public PlayerCrouchEvent() {
		super("Player Crouch Event", new DataType[]{}, new DataType[]{new PlayerType("player"), new BooleanType("crouching")});
	}
}
