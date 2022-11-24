package net.andrewcpu.script.parser.map2node;

import net.andrewcpu.halo.nodes.Node;
import net.andrewcpu.halo.type.DataType;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class BuiltInFunction<T extends DataType> {
    private String name;
    private Class<? extends Node> type;
    private DataType[] inputs;
    private List<Class<? extends DataType>> outputs;
    private int childParameterPosition;
    private Class<? extends DataType> executingOn;
    private Class<T> output;
    private int outputIndex;

    public BuiltInFunction(String name, Class<? extends Node> type, Class<? extends DataType> executingOn, DataType[] inputs, Class<T> output, List<Class<? extends DataType>> outputs, int childParameterPosition, int outputIndex) {
        this.name = name;
        this.type = type;
        this.inputs = inputs;
        this.output = output;
        this.outputs = outputs;
        this.executingOn = executingOn;
        this.childParameterPosition = childParameterPosition;
        this.outputIndex = outputIndex;
    }

    public Node instantiateNode() {
        try {
            Node node = (Node) (getType().getConstructors()[0].newInstance());
            return node;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public Class<? extends DataType> getExecutingOn() {
        return executingOn;
    }

    public String getName() {
        return name;
    }

    public Class<? extends Node> getType() {
        return type;
    }

    public DataType[] getInputs() {
        return inputs;
    }

    public List<Class<? extends DataType>> getOutputs() {
        return outputs;
    }

    public Class<T> getOutput() {
        return output;
    }

    public int getChildParameterPosition() {
        return childParameterPosition;
    }

    @Override
    public String toString() {
        return "BuiltInFunction{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", inputs=" + Arrays.toString(inputs) +
                ", outputs=" + (outputs) +
                ", output=" + output +
                ", childParameterPosition=" + childParameterPosition +
                '}';
    }

    public int getOutputIndex() {
        return outputIndex;
    }
}
