# Design Rationale
This document will summarise some of the design decisions made within the game as well as the reasons behind those decisions.

## Door Unlocking Behaviour
The planned bahviour is for a door to be unlocked when a character with a suitable key unlocks it. A door can be locked by any character, including those without keys. 
This may mean that NPCs or enemies may unlock doors the players wishes to go through without the player needing to obtain the key. Of course the NPC may relock the door once they pass through it.
This behavious was chosen because it seems like a more interesting experience to the player when NPCs may accidently assist the player achieve their goals.

## Character
The character class is an superclass intended to be extended by all other "actors". There are 3 main reasons for implementing the character class.
* Improved code modularity. Currently each actor overrides its play turn method to include its decision making. A character superclass will allows us to have only character override the play turn method. Subclasses will have a different interface for playing their turns.
* Add turn stages. Since play turn won't be overridden by each subclass we can change the flow of turns themselves. For instance at the beginning of each turn we can make it so a status effect is applied, then the character selects an action.
* Improve flexibility. Currently Actor is a fairly limited class with several values such as "intrinsic weapon" damage hard coded. Character allows us to override such behaviours and have a more flexible class for our code to inherit from.

## Controllers
Initially each Actor subclass would override play turn to include its own decision making logic for choosing an action. Controller is an interface that allows for different Controllers to be built and used on any character. The idea is that a controller selects an action for the character to perform allowing us to have decision making logic shared between different characters. Improves code modularity.


## Status Effects
The idea of status effects is to create tempoary effects on a character. The status effect is an abstract class that will be extended by subclasses. Status effects will be triggered as part of the characters turn.   
Status effects will have two designed use cases. 
*  They can change the character the are affecting in some way. For instance a status effect could increase character damage until its effect wears off.
*  They can return an action. A character will be forced to perform that action from the status effect and will be unable to select their own action for that turn.

## Stunning and Insults, One action only per turn.
We have decided that if an actor were to make an insult or a stun action as part of their behavior, it would be their one action for the turn. If we had made the choice to allow a movement action alongside the insult or stun, that would require quite a few changes to implement multiple actions per actor per turn. To keep things simple, when the world calls for an action from an actor, only 1 action will be taken.

## LogDisplay
The LogDisplay class extends the normal Display class and overrides it primary method (output to console). The default Display logic is to print the string passed to it as a console message. The LogDisplay changes this behaviour slightly and will both print to console and log the string into the debug.log file. This is to assist with debugging as we will have a log of all actions taken in that game instance.