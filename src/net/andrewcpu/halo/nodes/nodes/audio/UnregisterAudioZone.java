package net.andrewcpu.halo.nodes.nodes.audio;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.AreaMonitorType;
import net.andrewcpu.halo.type.DataType;

public class UnregisterAudioZone extends IONode {
	public UnregisterAudioZone() {
		super("Unregister Audio Zone", new DataType[]{new AreaMonitorType("audioMonitor")}, new DataType[]{});
	}
}
