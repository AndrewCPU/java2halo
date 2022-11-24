package net.andrewcpu.gui;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GUI {
    public static HashMap<String, Point> refPositions = new HashMap<>();
    public static HashMap<String, NodeGUIElement> draggables = new HashMap<>();
    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {
        File file = new File("C:\\Users\\stein\\Documents\\halo\\halo_json_example.json");
        try {
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(Files.readString(file.toPath()));
            JSONArray nodes = (JSONArray) jsonObject.get("nodes");
            new MainFrame(nodes);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


class MainFrame extends JFrame {
    public MainFrame(JSONArray array){
        setBounds(0,0,1000,1000);
        _Canvas canvas = new _Canvas(array);
        canvas.setBounds(0,0,1000,1000);
        add(canvas);
        addMouseMotionListener(canvas);
        addMouseListener(canvas);
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            canvas.repaint();
        }, 20, 20, TimeUnit.MILLISECONDS);
        setVisible(true);
    }
}
class _Canvas extends JComponent implements MouseMotionListener, MouseListener {
    private JSONArray array;
    private NodeGUIElement nodeGUIElement;
    public _Canvas(JSONArray array) {
        this.array = array;
        nodeGUIElement = new NodeGUIElement(new Point(0,0), (JSONObject) array.get(0));
    }


    public HashMap<String, Point> positionReferences = new HashMap<>();

    public void drawNode(JSONObject node, Graphics g) {
        int x = 50;
        int y = 50;
        nodeGUIElement.paint(g);
    }

    @Override
    public void paint(Graphics g) {
        JSONObject first = (JSONObject) array.get(0);
        g.setColor(Color.white);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.black);
        drawNode(first, g);
    }

    NodeGUIElement dragging = null;

    @Override
    public void mouseDragged(MouseEvent e) {
        dragging.setTopLeft(e.getPoint());
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point p = e.getPoint();
        for(String key : GUI.draggables.keySet()){
            Rectangle rectangle = GUI.draggables.get(key).bounds;
            if(rectangle.contains(p)) {
                dragging = GUI.draggables.get(key);
                return;
            }

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        dragging = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}