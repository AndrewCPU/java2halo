package net.andrewcpu.script.highlevel.types;

import net.andrewcpu.halo.type.UIMessageTemplateType;
import net.andrewcpu.script.highlevel.HighLevelObject;
import net.andrewcpu.script.highlevel.interfaces.HaloConstant;

public class MessageTemplate extends HighLevelObject<UIMessageTemplateType> implements HaloConstant<UIMessageTemplateType, MessageTemplate> {
	public MessageTemplate() {
		super(false);
	}

	@Override
	public java.lang.String[] getConstants() {
		return new java.lang.String[]{
				"current_object_string1",
				"you_are_a_string1",
				"you_are_the_string1",
				"player_is_a_string1",
				"player_is_the_string1",
				"string1",
				"string1_player",
				"string1_string2",
				"string1_the_string2",
				"string1_to_the_string2"
		};
	}

	@Override
	public Class<UIMessageTemplateType> getDataType() {
		return UIMessageTemplateType.class;
	}

	@Override
	public Class<MessageTemplate> getObjectType() {
		return MessageTemplate.class;
	}
}
