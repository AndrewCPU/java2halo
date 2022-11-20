package net.andrewcpu.script.parser.typemap.event_types;


import net.andrewcpu.halo.type.DeathContextType;
import net.andrewcpu.halo.type.PlayerType;

public abstract class PlayerKilledEvent extends EventElement{
	public PlayerKilledEvent() {
		//killed, killer, deathContext
	}
	public abstract PlayerType getKilled();
	public abstract PlayerType getKiller();
	public abstract DeathContextType getDeathContext();
}
