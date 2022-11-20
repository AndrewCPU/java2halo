package net.andrewcpu.halo.nodes.nodes.ui.nav;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.BooleanType;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NavMarkerType;
import net.andrewcpu.halo.type.TeamType;

public class SetNavMarkerTeamVisibility extends IONode {
	public SetNavMarkerTeamVisibility() {
		super("Set Nav Marker Team Visibility", new DataType[]{new NavMarkerType("navMarker"), new TeamType("team"), new BooleanType("otherTeams")}, new DataType[]{});
	}
}
