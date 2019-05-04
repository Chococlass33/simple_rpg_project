package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class StunnedAction extends Action {

    /**
     * How the action is described on the menu
     * @param actor The actor performing the action.
     * @return String to describe the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " stun self";
    }

    /**
     * The character is stunned.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return Message about the progress of the action.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return actor + " is stunned";
    }

    /**
     * Hotkey for stunned action.
     * @return Empty string since action does not have a hotkey
     */
    @Override
    public String hotKey() {
        return "";
    }
}
