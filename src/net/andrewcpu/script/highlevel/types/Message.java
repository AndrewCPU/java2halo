package net.andrewcpu.script.highlevel.types;

import net.andrewcpu.halo.type.PlayerType;
import net.andrewcpu.halo.type.StringType;
import net.andrewcpu.halo.type.UIMessageTemplateType;
import net.andrewcpu.halo.type.UIMessageType;
import net.andrewcpu.script.highlevel.HighLevelObject;
import net.andrewcpu.script.highlevel.TypedFunctionResult;

public class Message extends HighLevelObject<UIMessageType> {
	public Message() {
		super(true);
	}

	@Override
	public TypedFunctionResult[] getConstructorParameters() {
		return new TypedFunctionResult[]{
				TypedFunctionResult.of(new UIMessageTemplateType("template")),
				TypedFunctionResult.of(new StringType("string1")),
				TypedFunctionResult.of(new StringType("string2")),
				TypedFunctionResult.of(new PlayerType("player")),
		};
	}

	@Override
	public Class<UIMessageType> getDataType() {
		return null;
	}
}
