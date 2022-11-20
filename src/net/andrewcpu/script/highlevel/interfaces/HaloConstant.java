package net.andrewcpu.script.highlevel.interfaces;

import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.script.highlevel.HighLevelObject;

public interface HaloConstant <Q extends DataType, T extends HighLevelObject<Q>> {
	String[] getConstants();
	Class<Q> getDataType();
	Class<T> getObjectType();
}
