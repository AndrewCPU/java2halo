package net.andrewcpu.gui;

import org.json.simple.JSONObject;

import java.awt.*;

public class NodeGUIReference {
    private JSONObject object;
    private int height = 30;
    private int width = 145;

    private NodeGUIElement child;

    public NodeGUIReference(JSONObject object){
        this.object = object;
        if(object.containsKey("value")){
            if(object.get("value") instanceof JSONObject jsonObject){
                Point topLeft = new Point(0, 0);
                child = new NodeGUIElement(topLeft,jsonObject);
//                e.paint(g);
//                g.drawLine(x + width, yPos + (height / 2), topLeft.x, topLeft.y);
            }
        }
        if(object.containsKey("next")) {
            child = new NodeGUIElement(new Point(0,0), object);
        }
    }

    public void draw(int x, int y, int index, Graphics g) {
        int yPos = y + (height * (index+1));
//        g.drawRect(x, yPos, x + width, yPos + height);
        g.drawString(object.get("type").toString() + ":" + object.getOrDefault("name","").toString() + ":" + object.getOrDefault("_ref", "").toString(), x, yPos + height);
        if(object.containsKey("_ref")) {
            GUI.refPositions.put(object.get("_ref").toString(), new Point(x, yPos + (height / 2)));

        }
        if(child != null) {
            child.paint(g);
            g.drawLine(x + width, yPos + (height / 2), child.topLeft.x+width, child.topLeft.y);
        }
        if(object.containsKey("value")){
            if(object.get("value") instanceof String){
                if(GUI.refPositions.containsKey(object.get("value").toString()))
                {
                    g.drawLine(x, yPos + (height / 2), GUI.refPositions.get(object.get("value").toString()).x, GUI.refPositions.get(object.get("value").toString()).y);
                }
            }
        }
    }
}
