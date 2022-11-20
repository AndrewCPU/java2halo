package net.andrewcpu.script.parser.typemap.util;

import net.andrewcpu.halo.nodes.nodes.events.player.PlayerKilledEvent;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.PlayerType;
import net.andrewcpu.halo.type.TeamType;
import net.andrewcpu.script.parser.typemap.Player;
import net.andrewcpu.script.parser.typemap.Team;

public enum DataTypeToElement {
	PLAYER(PlayerType.class, Player.class),
	TEAM(TeamType.class, Team.class),
	;
	Class<DataType> dataType;
	Class<? extends TypeItem> element;

	public static Class<? extends TypeItem> fromType(Class<? extends DataType> className) {
		for(DataTypeToElement elem : values()){
			if(elem.getDataType() == className)
				return elem.getElement();
		}
		return null;
	}

	DataTypeToElement(Class dataType, Class element) {
		this.dataType = dataType;
		this.element = element;
	}

	public Class getDataType() {
		return dataType;
	}

	public Class getElement() {
		return element;
	}
}
