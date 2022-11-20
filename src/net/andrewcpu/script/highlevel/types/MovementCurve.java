package net.andrewcpu.script.highlevel.types;

import net.andrewcpu.halo.type.MovementCurveType;
import net.andrewcpu.script.highlevel.HighLevelObject;
import net.andrewcpu.script.highlevel.TypedFunctionResult;
import net.andrewcpu.script.highlevel.interfaces.HaloConstant;

public class MovementCurve extends HighLevelObject<MovementCurveType> implements HaloConstant<MovementCurveType, MovementCurve> {
	public MovementCurve() {
		super(false);
	}

	@Override
	public java.lang.String[] getConstants() {
		return new java.lang.String[] {
				"ease_in_circular",
				"ease_in_cubic",
				"ease_in_exponential",
				"ease_in_quadratic",
				"ease_in_quartic",
				"ease_in_quintic",
				"ease_in_sine",
				"ease_in_out_circular",
				"ease_in_out_cubic",
				"ease_in_out_exponential",
				"ease_in_out_quadratic",
				"ease_in_out_quartic",
				"ease_in_out_quintic",
				"ease_in_out_sine",
				"ease_out_circular",
				"ease_out_cubic",
				"ease_out_exponential",
				"ease_out_quadratic",
				"ease_out_quartic",
				"ease_out_quintic",
				"ease_out_sine",
				"linear",
				"one",
				"zero"
		};
	}

	@Override
	public Class<MovementCurveType> getDataType() {
		return MovementCurveType.class;
	}

	@Override
	public Class<MovementCurve> getObjectType() {
		return MovementCurve.class;
	}
}
