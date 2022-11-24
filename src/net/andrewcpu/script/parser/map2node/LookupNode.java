package net.andrewcpu.script.parser.map2node;

import net.andrewcpu.halo.nodes.AllNodes;
import net.andrewcpu.halo.nodes.Node;
import net.andrewcpu.halo.type.DataType;

import java.lang.reflect.InvocationTargetException;

public class LookupNode {
    public static Class<? extends Node> findNode(String name) {
        return AllNodes.getAllNodes().stream().filter(node -> node.getSimpleName().equals(name)).findFirst().get();
    }

    public static DataType[] getOutputOfNode(String name) {
        Class<? extends Node> nodeClass = findNode(name);
        try {
            Node node = (Node) nodeClass.getConstructors()[0].newInstance();
            return node.getOutputs();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    public static DataType[] getInputOfNode(String name) {
        Class<? extends Node> nodeClass = findNode(name);
        try {
            Node node = (Node) nodeClass.getConstructors()[0].newInstance();
            return node.getInputs();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
