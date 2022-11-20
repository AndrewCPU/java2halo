package net.andrewcpu.halo.nodes.nodes.ui.nav;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NavMarkerType;

public class ClearNavMarkerTeam extends IONode {
	public ClearNavMarkerTeam() {
		super("Clear Nav Marker Team", new DataType[]{new NavMarkerType("navMarker")}, new DataType[]{});
	}
}
