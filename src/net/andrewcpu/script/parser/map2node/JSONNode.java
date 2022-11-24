package net.andrewcpu.script.parser.map2node;

import net.andrewcpu.halo.nodes.Node;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ExecutionThreadType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

public class JSONNode<T extends Node> extends JSONObject {
    private JSONObject[] inputs;
    private JSONObject[] outputs;
    private JSONObject next = new JSONObject();
    private JSONArray nodeInputs = new JSONArray();
    private JSONArray nodeOutputs = new JSONArray();
    public JSONNode(Class<T> nodeClass, Class<? extends DataType> outputType) {
        try {
            Node node = (Node)((nodeClass.getConstructors()[0].newInstance()));
            inputs = new JSONObject[node.getInputs().length];
            outputs = new JSONObject[node.getOutputs().length];

            for(int i = 0; i<node.getInputs().length; i++) {
                inputs[i] = new JSONObject();
                inputs[i].put("type", node.getInputs()[i].getClass().getSimpleName());
                nodeInputs.add(inputs[i]);
            }
            for(int i = 0; i<node.getOutputs().length; i++){
                outputs[i] = new JSONObject();
                outputs[i].put("_ref", UUID.randomUUID().toString());
                nodeOutputs.add(outputs[i]);
            }
            if(outputType == null || outputType == ExecutionThreadType.class){
                put("type", nodeClass.getSimpleName());
                put("input", nodeInputs);
                put("output", nodeOutputs);
                put("next", next);
            }
            else{
                put("type", outputType.getSimpleName());
                JSONObject jobj = new JSONObject();
                jobj.put("type", nodeClass.getSimpleName());
                jobj.put("input", nodeInputs);
                jobj.put("output", nodeOutputs);
                jobj.put("value", ((JSONObject)nodeOutputs.get(0)).get("_ref"));
                put("value", jobj);
            }

        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONObject[] getInputs() {
        return inputs;
    }

    public JSONObject[] getOutputs() {
        return outputs;
    }

    public JSONObject getNext() {
        return next;
    }

    @Override
    public String toJSONString() {
        nodeInputs.clear();
        nodeOutputs.clear();
        for(JSONObject input : inputs) {
            nodeInputs.add(input);
        }
        for(JSONObject output : outputs) {
            nodeOutputs.add(output);
        }

        return super.toJSONString();
    }
}
