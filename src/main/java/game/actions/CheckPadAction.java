package game.actions;

import edu.monash.fit2099.engine.*;
import game.characters.Rocket;

/**
 * The actor inspects the rocket
 */
public class CheckPadAction extends Action {
    private boolean hasbody;
    private boolean hasengine;
    /**
     * Construct a CheckPad action
     *
     * @param hasBody Boolean representing the status of the rocket body.
     * @param hasEngine Boolean representing the status of the rocket engine.
     */
    public CheckPadAction(boolean hasBody, boolean hasEngine) {
        this.hasbody = hasBody;
        this.hasengine = hasEngine;
    }
    /**
     * An actor checks the rocket pad.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return A description of the action's outcome.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String tempstring = "You look at the pad.\n";
        if(hasbody)
        {
            tempstring += "The body is ready.\n";
        }
        else
        {
            tempstring += "The body is still needed to proceed.\n";
        }
        if(hasengine)
        {
            tempstring += "The engine is ready.\n";
        }
        else
        {
            tempstring += "The engine is still needed to proceed.\n";
        }
        return tempstring;
    }

    /**
     * How the action is described in a menu.
     *
     * @param actor The actor performing the action.
     * @return String of action desciption.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " checks the rocket.";
    }

    /**
     * Action hotkey.
     *
     * @return Return empty string. No dedicated hot key.
     */
    @Override
    public String hotKey() {
        return "";
    }
}
