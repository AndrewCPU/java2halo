package net.andrewcpu.script.parser.map2node.struct;

import net.andrewcpu.halo.nodes.Node;

import java.util.List;

public class FilledFunction {
    private Node node;
    private Object impliedReference;
    private List parameters;

    public FilledFunction(Node node, Object impliedReference, List parameters) {
        this.node = node;
        this.impliedReference = impliedReference;
        this.parameters = parameters;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Object getImpliedReference() {
        return impliedReference;
    }

    public void setImpliedReference(Object impliedReference) {
        this.impliedReference = impliedReference;
    }

    public List getParameters() {
        return parameters;
    }

    public void setParameters(List parameters) {
        this.parameters = parameters;
    }
}
