package net.andrewcpu.halo.nodes.nodes.ui.nav;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NavMarkerType;

public class SetNavMarkerEnabled extends IONode {
	public SetNavMarkerEnabled() {
		super("Set Nav Marker Enabled", new DataType[]{new NavMarkerType("navMarker"), new BooleanType("enabled")}, new DataType[]{});
	}
}
