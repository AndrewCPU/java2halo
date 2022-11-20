package net.andrewcpu.halo.nodes.nodes.ui;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;
import net.andrewcpu.halo.type.UIMessageType;

public class SetObjectiveBannerForPlayer extends IONode {
	public SetObjectiveBannerForPlayer() {
		super("Set Objective Banner for Player", new DataType[]{new PlayerType("player"), new BooleanType("enabled"), new UIMessageType("message")}, new DataType[]{});
	}
}
