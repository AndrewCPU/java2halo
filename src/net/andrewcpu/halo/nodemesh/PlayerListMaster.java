package net.andrewcpu.halo.nodemesh;

import net.andrewcpu.halo.type.PlayersType;

import java.util.List;

public class PlayerListMaster extends MasterCollection<PlayersType> {
	@Override
	public Class<PlayersType> getDataType() {
		return PlayersType.class;
	}

	@Override
	public List<PrefillNodeValue> getters() {
		return List.of();
	}

	@Override
	public List<PrefillNodeValue> setters() {
		return List.of();
	}

	@Override
	public List<PrefillNodeValue> functions() {
		return List.of();
	}
}
