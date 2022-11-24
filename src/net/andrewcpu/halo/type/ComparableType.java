package net.andrewcpu.halo.type;

import net.andrewcpu.halo.nodes.Node;

public interface ComparableType {
    Class<? extends Node> getComparisonNode();
}
