package game.actions;

import edu.monash.fit2099.engine.*;
import game.Items.RocketBody;
import game.Items.RocketEngine;
import game.ground.RocketPad;
/**
 * The actor puts parts into the rocket pad.
 */
public class PlacePartAction extends Action {
    private Location location;
    private boolean hasbody;
    private boolean hasengine;
    /**
     * Construct a PlacePart action
     *
     * @param location Location of the rocket pad.
     * @param hasBody Boolean representing the status of the rocket body.
     * @param hasEngine Boolean representing the status of the rocket engine.
     */
    public PlacePartAction(Location location, boolean hasBody, boolean hasEngine) {
        this.location = location;
        this.hasbody = hasBody;
        this.hasengine = hasEngine;
    }
    /**
     * An actor places parts into the rocket pad.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return A description of the action's outcome.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String tempstring = "You try to assemble the rocket.\n";
        boolean putbody = hasbody;
        boolean putengine = hasengine;
        if(!hasbody)
        {
            tempstring += "You notice the body is missing.\n";
            if(actor.getInventory().contains(new RocketBody()))
            {
                putbody = true;
                actor.getInventory().remove(new RocketBody());
                tempstring += "You attach the body to the launchpad.\n";
            }
            else
            {
                tempstring += "You still need to find the body.\n";
            }
        }
        if(!hasengine)
        {
            tempstring += "You notice the engine is missing.\n";
            if(actor.getInventory().contains(new RocketEngine()))
            {
                putengine = true;
                actor.getInventory().remove(new RocketEngine());
                tempstring += "You attach the engine to the launchpad.\n";
            }
            else
            {
                tempstring += "You still need to find the engine.\n";
            }
        }
        if(hasbody && hasengine)
        {
            tempstring += "The rocket is already finished.\n";
        }
        map.add(new RocketPad(putbody,putengine), location);
        if(putbody && putengine)
        {
            tempstring += "Woo, the rocket is finished.\nYou get in the rocket, and it explodes in a spectacular manner.\nTo be fair you put it together in like 5 minutes, craftsmanship isn't your forte.\nAs far as the game is concerned though, YOU'RE WINNER!\n";
            map.removeActor(actor);
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
        return actor + " puts components into the launchpad.";
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
