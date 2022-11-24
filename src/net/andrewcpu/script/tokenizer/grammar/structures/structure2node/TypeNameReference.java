package net.andrewcpu.script.tokenizer.grammar.structures.structure2node;

import net.andrewcpu.halo.type.DataType;
import org.json.simple.JSONObject;

import java.util.UUID;

public class TypeNameReference {
    private Class<? extends DataType> type;
    private String referenceName;
    private UUID reference;

    public TypeNameReference(Class<? extends DataType> type, String referenceName) {
        this.type = type;
        this.referenceName = referenceName;
        this.reference = UUID.randomUUID();
    }

    public Class<? extends DataType> getType() {
        return type;
    }

    public DataType getTypeInstance() {
        return DataType.nameToInstance(getType().getSimpleName());
    }

    public void setType(Class<? extends DataType> type) {
        this.type = type;
    }

    public String getReferenceName() {
        return referenceName;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    public UUID getReference() {
        return reference;
    }

    public void setReference(UUID reference) {
        this.reference = reference;
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type", type.getSimpleName());
        jsonObject.put("_ref", getReference().toString());
        jsonObject.put("name", getReferenceName());
        return jsonObject;
    }

    @Override
    public String toString() {
        return "TypeNameReference{" +
                "type=" + type +
                ", referenceName='" + referenceName + '\'' +
                ", reference=" + reference +
                '}';
    }
}
