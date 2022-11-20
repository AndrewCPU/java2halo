package net.andrewcpu.halo.nodes.nodes.ui;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.*;

public class CreateUIMessageB extends DataNode {
	public CreateUIMessageB() {
		super("Create UI Message [B]", new DataType[]{new UIMessageTemplateType("messageTemplate"), new StringType("string1"), new StringType("string2"), new PlayerType("player")}, new DataType[]{new UIMessageType("message")});
	}
}
