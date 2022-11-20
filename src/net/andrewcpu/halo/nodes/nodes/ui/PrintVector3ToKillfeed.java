package net.andrewcpu.halo.nodes.nodes.ui;

import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.VectorType;

public class PrintVector3ToKillfeed extends IONode {
	public PrintVector3ToKillfeed() {
		super("Print Vector3 to Killfeed", new DataType[]{new VectorType("value")}, new DataType[]{});
	}
}
