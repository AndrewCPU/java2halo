package net.andrewcpu.halo.nodes.nodes.ui.nav;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NavMarkerType;
import net.andrewcpu.halo.type.VectorType;

public class SetNavMarkerPosition extends IONode {
	public SetNavMarkerPosition() {
		super("Set Nav Marker Position", new DataType[]{new NavMarkerType("navMarker"), new VectorType("position")}, new DataType[]{});
	}
}
