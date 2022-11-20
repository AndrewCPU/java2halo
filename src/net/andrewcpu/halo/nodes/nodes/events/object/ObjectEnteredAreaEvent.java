package net.andrewcpu.halo.nodes.nodes.events.object;

import net.andrewcpu.halo.nodes.OutputOnlyNode;
import net.andrewcpu.halo.type.AreaMonitorType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectType;

public class ObjectEnteredAreaEvent extends OutputOnlyNode {
	public ObjectEnteredAreaEvent() {
		super("Object Entered Area Event", new DataType[]{new AreaMonitorType("areaMonitor")}, new DataType[]{new ObjectType("object")});
	}
}
