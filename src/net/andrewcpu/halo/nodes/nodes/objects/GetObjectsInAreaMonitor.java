package net.andrewcpu.halo.nodes.nodes.objects;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.AreaMonitorType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ObjectsType;

public class GetObjectsInAreaMonitor extends DataNode {
	public GetObjectsInAreaMonitor() {
		super("Get Objects in Area Monitor", new DataType[]{new AreaMonitorType("areaMonitor")}, new DataType[]{new ObjectsType("objectList")});
	}
}
