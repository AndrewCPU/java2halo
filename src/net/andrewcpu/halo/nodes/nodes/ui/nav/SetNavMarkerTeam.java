package net.andrewcpu.halo.nodes.nodes.ui.nav;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NavMarkerType;
import net.andrewcpu.halo.type.TeamType;

public class SetNavMarkerTeam extends IONode {
	public SetNavMarkerTeam() {
		super("Set Nav Marker Team", new DataType[]{new NavMarkerType("navMarker"), new TeamType("team")}, new DataType[]{});
	}
}
