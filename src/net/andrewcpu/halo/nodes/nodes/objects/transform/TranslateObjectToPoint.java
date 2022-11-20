package net.andrewcpu.halo.nodes.nodes.objects.transform;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.*;

public class TranslateObjectToPoint extends IONode {
	public TranslateObjectToPoint() {
		super("Translate Object to Point", new DataType[]{new ObjectType("object"), new VectorType("position"), new NumberType("duration"), new MovementCurveType("movementCurve")}, new DataType[]{});
	}
}
