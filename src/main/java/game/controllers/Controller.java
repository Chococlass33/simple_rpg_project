package game.controllers;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import game.characters.Character;

/**
 * The controller interface allows for different ways of characters being controlled.
 */
public interface Controller {

    /**
     * Select an action to perform. May return an empty optional.
     *
     * @param subject character to perform the action
     * @param actions collection of possible Actions for this Actor
     * @param map the map containing the Actor
     * @param display the I/O object to which messages may be written
     * @return the Action to be performed
     */
    Action selectedAction(Character subject, Actions actions, GameMap map, Display display);
}
