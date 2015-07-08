package com.wmb.simplerpg;

/**
 * Created by rob on 7/6/15.
 */
public class GameObject {
    public static int PC =0;
    public static int FOOD =1;
    public static int NPC=2;
    public static int GOLD =3;


    private int id;

    private int type;

    private GameObject() {
    }

    public GameObject(int id, int type) {
        this.id = id;
        this.type = type;
    }

    public GameObject(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameObject)) return false;

        GameObject that = (GameObject) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
