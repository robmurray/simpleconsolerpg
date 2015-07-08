package com.wmb.simplerpg;

import java.util.Scanner;

/**
 * Created by rob on 7/6/15.
 */
public class Game {

    private WorldMap worldMap;

    public Game() {

    }

    public void help(){
        print("To explore the world type one of the commands listed below followed by <enter>");
        print("--- commands ---");
        print(" north (n)");
        print(" south (s)");
        print(" east  (e)");
        print(" west  (w)");
        print(" quit  (q)");
        print(" map   (m)");
        print(" help  (h)");
        print("");

    }
    public void welcome(){
        print("Welcome to simple RPG.");
        print("");
    }
    public void start(){

        worldMap = new WorldMap();
        welcome();
        help();

        print(worldMap.pcAction(Control.MAP).getMessage());

        Scanner keyboard = new Scanner(System.in);
        String input = "";
        boolean quit = false;
        while(!quit){

            input = keyboard.nextLine().toLowerCase();

            // interpret command
            ActionResponse ar = null;
            if(input.equals("north") || input.equals("n")){
                ar =worldMap.pcAction(Control.NORTH);
                if(ar.isActionSuccess()){
                    print(worldMap.pcAction(Control.MAP).getMessage());
                }
            } else if(input.equals("south") || input.equals("s")){
                ar =worldMap.pcAction(Control.SOUTH);
                if(ar.isActionSuccess()){
                    print(worldMap.pcAction(Control.MAP).getMessage());
                }
            } else if(input.equals("west") || input.equals("w")){
                ar =worldMap.pcAction(Control.WEST);
                if(ar.isActionSuccess()){
                    print(worldMap.pcAction(Control.MAP).getMessage());
                }
            } else if(input.equals("east") || input.equals("e")){
                ar =worldMap.pcAction(Control.EAST);
                if(ar.isActionSuccess()){
                    print(worldMap.pcAction(Control.MAP).getMessage());
                }
            } else if(input.equals("quit") || input.equals("q")){
                ar =worldMap.pcAction(Control.QUIT);
                stop();
                quit = true;
            } else if(input.equals("map") || input.equals("m")){
                ar =worldMap.pcAction(Control.MAP);
            } else if(input.equals("help") || input.equals("h")) {
                help();
            }else{
                ar =worldMap.pcAction(Control.UNKNOWN);
            }
            if(ar!=null) {
                print(ar.getMessage());
            }

        }

    }

    public void stop(){
        print("Good bye adventurer.");
        print("thank you for playing simple RPG");
    }

    public static void print(String command){

        System.out.println("> "+ command);

    }

    public static void main(String args[]){
        Game theGame = new Game();
        theGame.start();
    }

}
