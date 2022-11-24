package net.andrewcpu.script.parser.map2node.struct;

import net.andrewcpu.script.tokenizer.Token;
import net.andrewcpu.script.tokenizer.grammar.structures.ItemList;

public class InvocationCollection {
    private Object actingOn;
    private Token action;
    private ItemList parameters;

    public InvocationCollection(Object actingOn, Token action, ItemList parameters) {
        this.actingOn = actingOn;
        this.action = action;
        this.parameters = parameters;
    }

    public Object getActingOn() {
        return actingOn;
    }

    public void setActingOn(Object actingOn) {
        this.actingOn = actingOn;
    }

    public Token getAction() {
        return action;
    }

    public void setAction(Token action) {
        this.action = action;
    }

    public ItemList getParameters() {
        return parameters;
    }

    public void setParameters(ItemList parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "InvocationCollection{" +
                "actingOn=" + actingOn +
                ", action=" + action +
                ", parameters=" + parameters +
                '}';
    }
}
