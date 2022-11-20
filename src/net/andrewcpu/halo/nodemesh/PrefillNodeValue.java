package net.andrewcpu.halo.nodemesh;

import net.andrewcpu.halo.nodes.Node;
import net.andrewcpu.halo.type.DataType;

import java.lang.reflect.InvocationTargetException;

public class PrefillNodeValue {
	private Node node;
	private int fillIndex;
	private String name;

	public static PrefillNodeValue of(Class nodeClass, int index, String name) {
		try {
			return new PrefillNodeValue((Node)nodeClass.getConstructors()[0].newInstance(), index,name);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
	public static PrefillNodeValue of(Class nodeClass, String name) {
		return of(nodeClass, -1, name);
	}

	public PrefillNodeValue(Node node, int fillIndex, String name) {
		this.node = node;
		this.fillIndex = fillIndex;
		this.name = name;
	}

	public Node getNode() {
		return node;
	}

	public int getFillIndex() {
		return fillIndex;
	}

	public String getName() {
		return name;
	}

	public DataType[] getInputNodes() {
		int count = getNode().getInputs().length - 1;
		if(fillIndex == -1) count = getNode().getInputs().length;
		if(count == 0) return new DataType[]{};
		DataType[] nodes = new DataType[count];
		int index = 0;
		for(int i = 0; i<getNode().getInputs().length; i++){
			if(i != getFillIndex()) {
				nodes[index++] = getNode().getInputs()[i];
			}
		}
		return nodes;
	}
}
