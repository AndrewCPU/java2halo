package net.andrewcpu.halo.nodes.nodes.traits;

import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.TraitsType;

public class GetRandomNTraits extends DataNode {
	public GetRandomNTraits() {
		super("Get Random N Traits", new DataType[]{new TraitsType("traitList"), new NumberType("n")}, new DataType[]{new TraitsType("randomList")});
	}
}
