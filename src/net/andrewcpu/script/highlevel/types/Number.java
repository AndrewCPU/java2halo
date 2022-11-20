package net.andrewcpu.script.highlevel.types;

import net.andrewcpu.halo.nodes.nodes.logic.Compare;
import net.andrewcpu.halo.nodes.nodes.math.Add;
import net.andrewcpu.halo.nodes.nodes.math.Subtract;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.NumberType;
import net.andrewcpu.script.highlevel.HighLevelObject;
import net.andrewcpu.script.highlevel.SimpleNodeBundle;
import net.andrewcpu.script.highlevel.TypedFunctionResult;
import net.andrewcpu.script.highlevel.interfaces.HaloArithmetic;
import net.andrewcpu.script.highlevel.interfaces.HaloComparable;

public class Number extends HighLevelObject<NumberType> implements HaloComparable<NumberType, Number, Compare>, HaloArithmetic<NumberType, Number, Add, Subtract> {
	public Number() {
		super(false);
	}

	@Override
	public SimpleNodeBundle<NumberType, Compare> equals(Number other) {
		return new SimpleNodeBundle<>(Compare.class,0, 0);
	}

	@Override
	public SimpleNodeBundle<NumberType, Compare> greaterThan(Number other) {
		return new SimpleNodeBundle<>(Compare.class,0, 1);
	}

	@Override
	public SimpleNodeBundle<NumberType, Compare> lessThan(Number other) {
		return new SimpleNodeBundle<>(Compare.class,0, 2);
	}

	@Override
	public TypedFunctionResult[] getConstructorParameters() {
		return null;
	}

	@Override
	public Class<NumberType> getDataType() {
		return NumberType.class;
	}

	@Override
	public SimpleNodeBundle<NumberType, Add> add(Number other) {
		return new SimpleNodeBundle<>(Add.class, 0);
	}

	@Override
	public SimpleNodeBundle<NumberType, Subtract> subtract(Number other) {
		return new SimpleNodeBundle<>(Subtract.class, 0);
	}
}
