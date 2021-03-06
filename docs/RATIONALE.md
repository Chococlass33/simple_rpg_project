# Design Rationale
This document will summarise some of the design decisions made within the game as well as the reasons behind those decisions.

## Door Unlocking Behaviour
The planned behaviour is for a door to be unlocked when a character with a suitable key unlocks it. A door can only be locked by a character with a suitable key.
This may mean that NPCs or enemies with the key may unlock doors the players wishes to go through without the player needing to obtain the key. Of course the NPC may relock the door once they pass through it.
This behaviours was chosen because it seems like a more interesting experience to the player when NPCs may accidentally assist the player achieve their goals.

## Character
The character class is an superclass intended to be extended by all other "actors". There are 3 main reasons for implementing the character class.
* Improved code modularity. Currently each actor overrides its play turn method to include its decision making. A character superclass will allows us to have only character override the play turn method. Subclasses will have a different interface for playing their turns.
* Add turn stages. Since play turn won't be overridden by each subclass we can change the flow of turns themselves. For instance at the beginning of each turn we can make it so a status effect is applied, then the character selects an action.
* Improve flexibility. Currently Actor is a fairly limited class with several values such as "intrinsic weapon" damage hard coded. Character allows us to override such behaviours and have a more flexible class for our code to inherit from.

## Controllers
Initially each Actor subclass would override play turn to include its own decision making logic for choosing an action. Controller is an interface that allows for different Controllers to be built and used on any character. The idea is that a controller selects an action for the character to perform allowing us to have decision making logic shared between different characters. Improves code modularity.


## Status Effects
The idea of status effects is to create temporary effects on a character. The status effect is an abstract class that will be extended by subclasses. Status effects will be triggered as part of the characters turn.
Status effects will have two designed use cases.
*  They can change the character the are affecting in some way. For instance a status effect could increase character damage until its effect wears off.
*  They can return an action. A character will be forced to perform that action from the status effect and will be unable to select their own action for that turn.

## Stunning and Insults, One action only per turn.
We have decided that if an actor were to make an insult or a stun action as part of their behaviour, it would be their one action for the turn. If we had made the choice to allow a movement action alongside the insult or stun, that would require quite a few changes to implement multiple actions per actor per turn. To keep things simple, when the world calls for an action from an actor, only 1 action will be taken.

## Controllers
Initially each Actor subclass would override play turn to include its own decision making logic for choosing an action. Controller is an interface that allows for different Controllers to be built and used on any character.

## Display Characters
In the game everything is rendered on the map as a Java character. In order to prevent unexpected behaviour when different classes use the same display character the DisplayCharacters class was designed. Normally all the display characters are declared within different classes, this could result in difficulty understanding which characters have already been reserved. The display character class only has static final values within it. It only exists to place all the display characters for our game into a single place to make it easier to manage.

## Chaos
Non-player characters go through their behaviours. If no behaviours are selected they interact with the world around them. This results in strange situations, such as a grunt stunning Doctor Maybe and then picking up the rocket engine. These behaviours could be coded out if we wanted to. But the chaos often makes for a more interesting experience so we didn't attempt to restrict these chaotic behaviours.

## VacuumEffect
We decided to implement suffocation as part of the status effect system. The VacuumEffect will cause characters to be teleported back to the first map if they can't breath. A character can breath if they have a spacesuit and sufficent supplies of Oxygen. We decided to apply/remove the VacuumEffect exclusively to the player character when teleporting between the moon and normal map. The desired behaviour is for only the character to suffocate while other characters on the moon are immune. Rather than designing new objects to make enemies immune to the VacuumEffect we will simply not apply the VacuumEffect to them.

## Exoskeleton
One of the enemies will be immune to damage, as a resuult of an exoskeleton. We plan to implement this with three aspects:
* A armour stat in our character class. Armour will reduce all incoming damage by the amount of armour on the character. So a character with three armour taking 5 damage will only lose 2 health.
* An exoskelton item that applies the armoured status effect to a character.
* An armoured status that raises a character's armour stat while active.

Invulnerability to damage will be achieved by applying a massive ArmourStatus bonus to exoskeleton wearing characters.