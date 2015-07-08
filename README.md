#Simple Console RPG
After years of enterprise app development I have decided to cultivate an interest in game development. 
My approach for the initial ramp up is to explore different aspects of game development via time boxed 
coding efforts.

Simple Console RPG is my initial effort at a RPG style game. 

Time: a couple codng sessions

In this first project I will be developing a simple single player turned based RPG game. 
The main objective of this exercise is to get my feet wet with tile based games, 
explore various useful data structures and discover appropriate design patterns 
for turned based RPG style games. There are lots of articles on game development out there
so I will definitely be looking to the web to get started.


## build/run
>$ mvn clean install
>$ java -jar target/simplerpg.jar


##Requirements
- single player RPG style game
- 10 x 10 grid world
- fog of war
- grid cells are of type {water, plain. mountain}
- mountains are impassable
- water passable but chance of being eaten
- the pc is moved via the arrow keys in cardinal directions
- player can view contents of the current grid cell (tile)
- player can pick up gold
- player can eat food
- The UI will be text based, driven from the console.


#misc design ideas

##world map 
I think the world map design will be very interesting especially as the world size grows large. 
ultimately a world of infinite size is the goal. For today a far more attainable goal of a 10 x 10 grid 
is in the sites.

The world map will be a two dimensional array of tiles. the Tiles will contain 0 to many game objects.

For this version the coordinates will be implied by the two dimensional array. 
I can see as the map get bigger this will become inefficient but that is a problem for another day.

##Tile
consist of a type and 0 to many gameObjects.

##GameObjects
consists of anything that is not terrain: PC, NPC, FOOD, GOLD. All game objects will have a unique identifier.

##Navigation/user input
Originally navigation was going to be managed via the arrow keys. 
This however proved to be a PITA. Also I discovered that none blocking input on a console 
application is not portable. So updating the spec.

All user commands must be followed by a carriage return.

User commands:
(n)orth
(s)outh
(e)ast
(w)est 
(m)ap - display map
(h)elp - display help
(q)uit - exit the game

invalid commands are ignored
