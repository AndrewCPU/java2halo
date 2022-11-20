package net.andrewcpu.script.parser.typemap;

import net.andrewcpu.halo.type.*;
import net.andrewcpu.script.parser.typemap.util.MultiResponseType;
import net.andrewcpu.script.parser.typemap.util.NamedResult;
import net.andrewcpu.script.parser.typemap.util.TypeItem;

public abstract class Team extends TypeItem {
	public abstract ExecutionThreadType adjustPoints(NumberType amount);

	public abstract ExecutionThreadType print();

	public abstract BooleanType equal(TeamType team);


	public abstract NumberType getTotalPoints();
	public abstract NumberType getRoundPoints();

	public abstract ObjectsType getAllSpawnPoints();

	public abstract PlayersType getPlayers();
}
