package net.andrewcpu.halo.nodes.nodes.events.object;

import net.andrewcpu.halo.nodes.OutputOnlyNode;
import net.andrewcpu.halo.type.AreaMonitorType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectType;

public class ObjectExitedAreaEvent extends OutputOnlyNode {
	public ObjectExitedAreaEvent() {
		super("Object Exited Area Event", new DataType[]{new AreaMonitorType("areaMonitor")}, new DataType[]{new ObjectType("object")});
	}
}
