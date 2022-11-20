package net.andrewcpu.halo.nodemesh;

import net.andrewcpu.halo.nodes.nodes.math.*;
import net.andrewcpu.halo.nodes.nodes.ui.PrintVector3ToKillfeed;
import net.andrewcpu.halo.type.VectorType;

import java.util.List;

public class VectorMaster extends MasterCollection<VectorType> {
	@Override
	public Class<VectorType> getDataType() {
		return VectorType.class;
	}

	@Override
	public List<PrefillNodeValue> getters() {
		return List.of(
				PrefillNodeValue.of(AddVectors.class, 0, "add"),
				PrefillNodeValue.of(GetVectorAxisValue.class, 0, "getAxisLength"),
				PrefillNodeValue.of(GetVectorLength.class, 0, "getLength"),
				PrefillNodeValue.of(NormalizeVector.class, 0, "normalize"),
				PrefillNodeValue.of(ScaleVector.class, 0, "scale"),
				PrefillNodeValue.of(SubtractVectors.class,0,"subtract"),
				PrefillNodeValue.of(VectorCrossProduct.class,0,"crossProduct"),
				PrefillNodeValue.of(VectorDotProduct.class,0,"dotProduct")
		);
	}

	@Override
	public List<PrefillNodeValue> setters() {
		return List.of();
	}

	@Override
	public List<PrefillNodeValue> functions() {
		return List.of(
				PrefillNodeValue.of(PrintVector3ToKillfeed.class, 0, "print")
		);
	}
}
