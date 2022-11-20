package net.andrewcpu.halo.nodes.nodes.objects.transform;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.MovementCurveType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.ObjectType;

public class MoveObjectToTransform extends IONode {
	public MoveObjectToTransform() {
		super("Move Object to Transform", new DataType[]{new ObjectType("object"), new ObjectType("destination"), new NumberType("seconds"), new MovementCurveType("movementCurve")}, new DataType[]{});
	}
}
