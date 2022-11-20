package net.andrewcpu.halo.nodes.nodes.ui;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;

public class ClearSplashForPlayer extends IONode {
	public ClearSplashForPlayer() {
		super("Clear Splash for Player", new DataType[]{new PlayerType("player")}, new DataType[]{});
	}
}
