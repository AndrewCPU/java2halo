package net.andrewcpu.halo.nodes.nodes.ui.nav;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.IdentifierType;
import net.andrewcpu.halo.type.NavMarkerType;

public class NavMarker extends DataNode {
	public NavMarker() {
		super("Nav Marker", new DataType[]{new IdentifierType("identifier")}, new DataType[]{new NavMarkerType("navMarker")});
	}
}
