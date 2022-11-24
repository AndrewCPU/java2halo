package net.andrewcpu.script.tokenizer.grammar.structures.structure2node;

import net.andrewcpu.halo.nodes.Node;
import net.andrewcpu.halo.type.DataType;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

public class NodeConnection {
    public Class<? extends Node> node;
    public TypeNameReference[] input;
    public TypeNameReference[] output;
    public NodeConnection previous;
    public NodeConnection next;
    private TypeNameReference value;

    public NodeConnection(Class<? extends Node> node, TypeNameReference[] input) {
        this.node = node;
        this.input = input;
        _generateOutput();
    }

    private void _generateOutput() {
        try {
            Node node = (Node) this.node.getConstructors()[0].newInstance();
            output = new TypeNameReference[node.getOutputs().length];
            for(int i = 0; i<output.length; i++) {
                output[i] = new TypeNameReference(node.getOutputs()[i].getClass(), UUID.randomUUID().toString());
            }
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
