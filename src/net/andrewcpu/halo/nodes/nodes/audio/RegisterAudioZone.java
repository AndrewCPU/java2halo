package net.andrewcpu.halo.nodes.nodes.audio;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.AreaMonitorType;
import net.andrewcpu.halo.type.AudioZoneEffectType;
import net.andrewcpu.halo.type.DataType;

public class RegisterAudioZone extends IONode {
	public RegisterAudioZone() {
		super("Register Audio Zone", new DataType[]{new AreaMonitorType("areaMonitor"), new AudioZoneEffectType("audioZoneEffect")}, new DataType[]{});
	}
}
