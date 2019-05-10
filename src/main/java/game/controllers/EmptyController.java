package game.controllers;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import game.characters.Character;

import java.util.Optional;

public class EmptyController implements Controller {


    /**
     * Return no action.
     *
     * @param subject The character to perform the action
     * @param actions collection of possible Actions for this Actor
     * @param map     the map containing the Actor
     * @param display the I/O object to which messages may be written
     * @return Action to be performed.
     */
    public Optional<Action> selectedAction(Character subject, Actions actions, GameMap map, Display display) {
        return Optional.empty();
    }
}
