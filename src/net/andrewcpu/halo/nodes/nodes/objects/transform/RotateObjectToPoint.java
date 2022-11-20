package net.andrewcpu.halo.nodes.nodes.objects.transform;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.*;

public class RotateObjectToPoint extends IONode {
	public RotateObjectToPoint() {
		super("Rotate Object to Point", new DataType[]{new ObjectType("object"), new VectorType("rotation"), new NumberType("seconds"), new MovementCurveType("movementCurve")}, new DataType[]{});
	}
}
