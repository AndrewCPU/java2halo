package net.andrewcpu.halo.nodes.nodes.variables.basic;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.AreaMonitorType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectType;

public class AreaMonitorVariable extends DataNode {
	public AreaMonitorVariable() {
		super("Area Monitor Variable", new DataType[]{new ObjectType("object")}, new DataType[]{new AreaMonitorType("areaMonitor")});
	}
}
