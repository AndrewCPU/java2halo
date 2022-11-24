package net.andrewcpu.script.parser.map2node.struct;

import net.andrewcpu.script.tokenizer.Token;
import org.json.simple.JSONObject;

public class ConstantValue {
    private Token type;
    private Token value;

    public ConstantValue(Token type, Token value) {
        this.type = type;
        this.value = value;
    }

    public Token getType() {
        return type;
    }

    public Token getValue() {
        return value;
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type", type.getValue());
        jsonObject.put("constant", value.getValue());
        return jsonObject;
    }

    @Override
    public String toString() {
        return "ConstantValue{" +
                "type=" + type +
                ", value=" + value +
                '}';
    }
}
