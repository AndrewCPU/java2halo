package net.andrewcpu.halo.nodes.nodes.ui;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.*;

public class CreateUIMessage extends DataNode {
	public CreateUIMessage() {
		super("Create UI Message", new DataType[]{new UIMessageTemplateType("messageTemplate"), new StringType("string1"), new StringType("string2"), new PlayerType("player")}, new DataType[]{new UIMessageType("message")});
	}
}
