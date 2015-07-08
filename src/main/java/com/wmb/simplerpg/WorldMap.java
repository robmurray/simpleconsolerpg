package com.wmb.simplerpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by rob on 7/6/15.
 */
public class WorldMap {

    public static final int SIZE = 20;

    // the world
    private Tile[][] map;

    // the player character
    private GameObject pc;

    private int pcX = 5;

    private int pcY = 5;

    // stores the game objects in play
    private List<GameObject> gameObjects;

    private Random rand = new Random();

    /**
     * create a new world
     */
    public WorldMap() {
        map = new Tile[SIZE][SIZE];
        gameObjects = new ArrayList<GameObject>();

        GameObject gameObject = null;
        Tile theTile = null;
        boolean pcCreated = false;
        for (int colIndex = 0; colIndex < SIZE; colIndex++) {
            for (int rowIndex = 0; rowIndex < SIZE; rowIndex++) {
                gameObject = selectGameObject();
                theTile = selectTile();
                if (gameObject != null) {
                    theTile.addContent(gameObject);
                }
                map[rowIndex][colIndex] = theTile;
            }
        }

        // add the pc to the middle of the map
        pc = createGameObject(GameObject.PC);
        map[this.pcX][this.pcY].setType(Tile.PLAIN);
        map[this.pcX][this.pcY].addContent(pc);
        liftFogOfWar();

    }

    private GameObject createGameObject(int type) {
        GameObject go = new GameObject(this.gameObjects.size(), type);
        gameObjects.add(go);
        return go;
    }


    public ActionResponse pcAction(Control nav) {
        ActionResponse ar = new ActionResponse(true);
        int wrkX = this.pcX;
        int wrkY = this.pcY;
        try {
            if (nav == Control.EAST) {
                this.movePC(++wrkX, wrkY);
                ar.setMessage("heading east");
            } else if (nav == Control.WEST) {
                this.movePC(--wrkX, wrkY);
                ar.setMessage("heading west");
            } else if (nav == Control.SOUTH) {
                this.movePC(wrkX, ++wrkY);
                ar.setMessage("heading south");
            } else if (nav == Control.NORTH) {
                this.movePC(wrkX, --wrkY);
                ar.setMessage("heading north");
            } else if (nav == Control.QUIT) {
                ar.setMessage("good bye");
            } else if (nav == Control.MAP) {
                ar.setMessage(this.mapToString());
            } else {
                ar.setMessage("... what?");
                ar.setActionSuccess(false);
            }

        } catch (EdgeOfTheWorldException e) {
            return new ActionResponse("a vast abyss lies before thee. you may travel no further", false);
        } catch (ImpassableTerrainException e) {
            return new ActionResponse("the terrain before thee is impassible. You may travel no further in this direction", false);
        }
        return ar;
    }

    private String mapToString() {
        String theMapAsAString = "\n";
        Tile currentTile = null;
        for (int colIndex = 0; colIndex < SIZE; colIndex++) {
            for (int rowIndex = 0; rowIndex < SIZE; rowIndex++) {

                currentTile = map[rowIndex][colIndex];
                if (currentTile == null) {
                    throw new RuntimeException("null tile. map is broken. needs fixing");
                }
                if (currentTile.containsPC(this.pc)) {
                    theMapAsAString += "  O  ";
                }else if (!currentTile.isVisited()) {
                    theMapAsAString += "#####";
                } else if (currentTile.getType() == Tile.PLAIN) {
                    theMapAsAString += "  .  ";
                } else if (currentTile.getType() == Tile.MOUNTAIN) {
                    theMapAsAString += " ^^^ ";
                } else if (currentTile.getType() == Tile.WATER) {
                    theMapAsAString += " www ";
                }

            }
            theMapAsAString += "\n";

        }


        return theMapAsAString;
    }

    private void movePC(int x, int y) throws EdgeOfTheWorldException, ImpassableTerrainException {


        if (x >= SIZE || x < 0 || y < 0 || y >= SIZE) {
            throw new EdgeOfTheWorldException();
        }
        // look ahead
        Tile targetTile = this.map[x][y];
        if(targetTile.getType()==Tile.MOUNTAIN){
            throw new ImpassableTerrainException("");
        }


        Tile playerTile = this.map[this.pcX][this.pcY];
        playerTile.removeContent(pc);
        this.pcX = x;
        this.pcY = y;
        playerTile = this.map[this.pcX][this.pcY];
        playerTile.addContent(pc);
        playerTile.setVisited(true);

        liftFogOfWar();
    }
    private void liftFogOfWar(){
        if(this.pcY<SIZE-1) {
            this.map[this.pcX][this.pcY + 1].setVisited(true);
        }
        if(this.pcY>1) {
            this.map[this.pcX][this.pcY - 1].setVisited(true);
        }
        if(this.pcX<SIZE-1) {
            this.map[this.pcX + 1][this.pcY].setVisited(true);
        }
        if(this.pcX>1) {
            this.map[this.pcX - 1][this.pcY].setVisited(true);
        }
        if(this.pcY<SIZE-1 &&this.pcX<SIZE-1) {
            this.map[this.pcX+1][this.pcY + 1].setVisited(true);
        }
        if(this.pcY>1 &&this.pcX>1) {
            this.map[this.pcX-1][this.pcY - 1].setVisited(true);
        }
        if(this.pcY>1 &&this.pcX<SIZE-1) {
            this.map[this.pcX+1][this.pcY - 1].setVisited(true);
        }
        if(this.pcY<SIZE-1 &&this.pcX>1) {
            this.map[this.pcX-1][this.pcY + 1].setVisited(true);
        }
    }
    public void npcMode() {

    }

    // helper methods
    /*
     * helper method to select a random game object or null
     * @return the object to include in the game
     */
    private GameObject selectGameObject() {
        GameObject go = null;
        int randInt = this.randomInt(0, 3);
        if (randInt > 0) {
            go = createGameObject(randInt);
        }
        return go;
    }


    private Tile selectTile() {
        return new Tile(this.randomInt(0, 2));
    }

    private int randomInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }

}
