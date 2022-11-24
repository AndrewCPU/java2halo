package net.andrewcpu.gui;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class NodeGUIElement {
    private JSONObject object;
    public Point topLeft;
    private List<NodeGUIReference> items = new ArrayList<>();
    private NodeGUIElement next;
    private String id;


    public NodeGUIElement(Point topLeft, JSONObject object) {
        this.topLeft = topLeft;
        this.object = object;
        _generateItems();
        id = UUID.randomUUID().toString();
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public void _generateItems() {
        JSONArray inputs = (JSONArray) object.get("input");
        JSONArray outputs = (JSONArray) object.get("output");
        items.addAll((Collection<? extends NodeGUIReference>) inputs.stream().map(o -> new NodeGUIReference((JSONObject)o)).collect(Collectors.toList()));
        items.addAll((Collection<? extends NodeGUIReference>) outputs.stream().map(o -> new NodeGUIReference((JSONObject)o)).collect(Collectors.toList()));
        if(object.containsKey("next") && object.get("next") != null) {

            Point topLeft1 = new Point(topLeft.x + (145 * 2), topLeft.y + 0);
            NodeGUIElement element = new NodeGUIElement(topLeft1, (JSONObject) object.get("next"));
            next = element;
        }
    }

    public Rectangle bounds = null;

    public void paint(Graphics g) {
        g.drawString(object.get("type").toString(), topLeft.x + 10, topLeft.y + 10);
        int index = 0;
        int endY = topLeft.y+30;
        for(NodeGUIReference reference : items) {
            reference.draw(topLeft.x, topLeft.y, index, g);
            index++;
            endY += 30;
        }
        g.drawRect(topLeft.x, topLeft.y, 145, endY - topLeft.y);
        bounds = ( new Rectangle(topLeft.x, topLeft.y, 145, endY - topLeft.y));
        GUI.draggables.put(id, this);

        if(next != null) {
            next.paint(g);
            g.drawLine(topLeft.x, topLeft.y, next.topLeft.x, next.topLeft.y);
        }
    }
}
