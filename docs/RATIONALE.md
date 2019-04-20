# Design Rationale
This document will summarise some of the design decisions made within the game as well as the reasons behind those decisions.

## Door Unlocking Behaviour
The planned bahviour is for a door to be unlocked when a character with a suitable key unlocks it. A door can be locked by any character, including those without keys. 
This may mean that NPCs or enemies may unlock doors the players wishes to go through without the player needing to obtain the key. Of course the NPC may relock the door once they pass through it.
This behavious was chosen because it seems like a more interesting experience to the player when NPCs may accidently assist the player achieve their goals.

## Character Class
The character class is a planned superclass for all NPCs, enemies, and the player. The character class is intended to implement additinoal common functionality between game characters. For example it
is planned to implement "StatusEffects". These are buff or debuffs that affect a character, such as disabling them for some time. It will also allows for functionality such as dropping items on "death"
 for characters. It is also planned to add some more flexibility to creation of characters, such as setting stats of characters during creation. For example it will allow us to set "Docter Maybe" to have a really weak
 intrinsic weapon.

## Status Effects
The idea of status effects is to create tempoary effects on a character. The status effect is an abstract class that will be extended by subclasses. Status effects will be triggered as part of the characters turn
. For example a player afflicted with stun will be incapable of performing actions until the effect wears off. Each time the status effect is triggered it will reduce a counter of turns remaining. 
This isn't the only way to implement a stun effect. I chose this way because it allow for furture extension of the status system. We could add healing buffs or damage buffs later down the line fairly easily through
this status effect interface. The engine doesn't really have a system in place for non-damage item actions.

## Stunning and Insults, One action only per turn.
We have decided that if an actor were to make an insult or a stun action as part of their behavior, it would be their one action for the turn. If we had made the choice to allow a movement action alongside the insult or stun, that would require quite a few changes to implement multiple actions per actor per turn. To keep things simple, when the world calls for an action from an actor, only 1 action will be taken.