package net.andrewcpu.halo.nodes.nodes.ui.nav;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NavMarkerType;
import net.andrewcpu.halo.type.ObjectType;
import net.andrewcpu.halo.type.VectorType;

public class AttachNavMarkerToObject extends IONode {
	public AttachNavMarkerToObject() {//nav, object, offset
		super("Attach Nav Marker to Object", new DataType[]{new NavMarkerType("navMarker"), new ObjectType("object"), new VectorType("offset")}, new DataType[]{});
	}
}
