package net.andrewcpu.halo.nodes.nodes.ui.nav;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NavMarkerType;
import net.andrewcpu.halo.type.StringType;

public class SetNavMarkerText extends IONode {
	public SetNavMarkerText() {
		super("Set Nav Marker Text", new DataType[]{new NavMarkerType("navMarker"), new StringType("text")}, new DataType[]{});
	}
}
