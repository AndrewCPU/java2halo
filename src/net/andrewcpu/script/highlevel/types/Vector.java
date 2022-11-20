package net.andrewcpu.script.highlevel.types;

import net.andrewcpu.halo.nodes.nodes.math.AddVectors;
import net.andrewcpu.halo.nodes.nodes.math.SubtractVectors;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.halo.type.VectorType;
import net.andrewcpu.script.highlevel.HighLevelObject;
import net.andrewcpu.script.highlevel.SimpleNodeBundle;
import net.andrewcpu.script.highlevel.TypedFunctionResult;
import net.andrewcpu.script.highlevel.interfaces.HaloArithmetic;
import net.andrewcpu.script.highlevel.interfaces.HaloComparable;

public class Vector extends HighLevelObject<VectorType> implements HaloArithmetic<VectorType, Vector, AddVectors, SubtractVectors> {
	public Vector() {
		super(true);
	}

	@Override // Vector(x, y, z);
	public TypedFunctionResult[] getConstructorParameters() {
		return new TypedFunctionResult[]{new TypedFunctionResult(new NumberType("x"),"x"),new TypedFunctionResult(new NumberType("y"),"y"),new TypedFunctionResult(new NumberType("z"),"z")};
	}

	@Override
	public Class<VectorType> getDataType() {
		return VectorType.class;
	}

	@Override
	public SimpleNodeBundle<VectorType, AddVectors> add(Vector other) {
		return new SimpleNodeBundle<>(AddVectors.class, 0);
	}

	@Override
	public SimpleNodeBundle<VectorType, SubtractVectors> subtract(Vector other) {
		return new SimpleNodeBundle<>(SubtractVectors.class, 0);
	}
}
