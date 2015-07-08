package com.wmb.simplerpg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rob on 7/6/15.
 */
public class Tile {

    public static int WATER=0;
    public static int PLAIN=1;
    public static int MOUNTAIN=2;

    private int type;

    private boolean visited;

    private List<GameObject> content = new ArrayList<GameObject>();


    public Tile() {
        type = PLAIN;
    }

    public Tile(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void addContent(GameObject obj){
        content.add(obj);
    }

    public void removeContent(GameObject obj){
        content.remove(obj);
    }

    public List<GameObject> getContent() {
        return content;
    }

    public boolean containsPC(GameObject go){
        return content.contains(go);
    }
}
