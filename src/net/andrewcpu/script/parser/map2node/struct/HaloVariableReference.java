package net.andrewcpu.script.parser.map2node.struct;

import net.andrewcpu.halo.nodes.nodes.variables.advanced.IISNode;
import net.andrewcpu.halo.nodes.nodes.variables.advanced.ISONode;
import net.andrewcpu.halo.nodes.nodes.variables.advanced.IVSONode;
import net.andrewcpu.halo.type.DataType;
import org.json.simple.JSONObject;

public class HaloVariableReference<X extends IISNode, T extends ISONode, Z extends IVSONode> {
    private String name;
    private String scope;
    private DataType type;
    private Class<X> iis;
    private Class<T> iso;
    private Class<Z> ivso;

    public HaloVariableReference(String scope, String name,  DataType type, Class<X> iis, Class<T> iso, Class<Z> ivso) {
        this.scope = scope;
        this.name = name;
        this.type = type;
        this.iis = iis;
        this.iso = iso;
        this.ivso = ivso;
    }//iis declar ivso setter iso getter

    public Class<X> getDeclarationNode() {
        return iis;
    }

    public Class<T> getVariableGetter() {
        return iso;
    }

    public Class<Z> getVariableSetter() {
        return ivso;
    }

    public String getScope() {
        return scope;
    }

    public JSONObject declare(JSONObject initialValue) {
        return null;
    }
    public JSONObject get() {
        return null;
    }
    public JSONObject set(JSONObject value) {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataType getType() {
        return type;
    }

    public void setType(DataType type) {
        this.type = type;
    }
}
