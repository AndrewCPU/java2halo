package net.andrewcpu.script.parser.map2node;

import net.andrewcpu.halo.nodes.AllNodes;
import net.andrewcpu.halo.nodes.nodes.variables.advanced.IISNode;
import net.andrewcpu.halo.nodes.nodes.variables.advanced.ISONode;
import net.andrewcpu.halo.nodes.nodes.variables.advanced.IVSONode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.script.parser.map2node.struct.HaloVariableReference;
import net.andrewcpu.script.tokenizer.Token;
import net.andrewcpu.script.tokenizer.TokenType;
import net.andrewcpu.script.tokenizer.grammar.structures.structure2node.TypeNameReference;

import java.util.HashMap;

public class Scope {
    private Scope parentScope;
    private HashMap<String, TypeNameReference> scope;
    private HashMap<String, HaloVariableReference> localVariables;
    private HashMap<String, HaloVariableReference> globalVariables;

    public Scope(Scope parentScope) {
        this.parentScope = parentScope;
        scope = new HashMap<>();
        globalVariables = new HashMap<>();
        localVariables = new HashMap<>();
    }

    public void haloDeclare(Token scope, Token name, DataType type) {
        Class<? extends IISNode> iis = AllNodes.getVariableDeclarationForType(type);
        Class<? extends ISONode> iso = AllNodes.getVariableGetterForType(type);
        Class<? extends IVSONode> ivso = AllNodes.getVariableSetterForType(type);
        HaloVariableReference value = new HaloVariableReference(scope.getValue(), name.getValue(), type, iis, iso, ivso);

        if(scope.getType() == TokenType.GLOBAL_DECLARATION) {
            globalVariables.put(name.getValue(), value);
        }
        else{
            localVariables.put(name.getValue(), value);
        }
    }

    public HaloVariableReference getHalo(String name) {
        if(localVariables.containsKey(name)) {
            return localVariables.get(name);
        }
        else if(globalVariables.containsKey(name)){
            return globalVariables.get(name);
        }
        else if(parentScope != null){
            return parentScope.getHalo(name);
        }
        return null;
    }

    public void declare(TypeNameReference typeNameReference) {
        scope.put(typeNameReference.getReferenceName(), typeNameReference);
    }

    public TypeNameReference get(String name) {
        TypeNameReference ref = scope.get(name);
        if(ref == null && parentScope != null){
            return parentScope.get(name);
        }
        return ref;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
