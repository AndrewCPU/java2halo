package net.andrewcpu.script.tokenizer.grammar.structures;

import net.andrewcpu.script.tokenizer.Token;

public class ValueAssignmentStructure {
    private Token name;
    private Object value;

    public ValueAssignmentStructure(Token name, Object value) {
        this.name = name;
        this.value = value;
    }

    public Token getName() {
        return name;
    }

    public void setName(Token name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ValueAssignmentStructure[" +
                "name=" + name +
                ", value=" + value +
                ']';
    }
}
