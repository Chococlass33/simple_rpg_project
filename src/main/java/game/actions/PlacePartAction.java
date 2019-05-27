package game.actions;

import edu.monash.fit2099.engine.*;
import game.characters.Rocket;
import game.items.RocketBody;
import game.items.RocketEngine;
import game.ground.RocketPad;

import java.util.List;

/**
 * The actor puts parts into the rocket pad.
 */
public class PlacePartAction extends Action {
    private Rocket rocket;
    private boolean hasbody;
    private boolean hasengine;

    /**
     * Construct a PlacePart action
     *
     * @param rocket    Points to the rocket.
     * @param hasBody   Boolean representing the status of the rocket body.
     * @param hasEngine Boolean representing the status of the rocket engine.
     */
    public PlacePartAction(Rocket rocket, boolean hasBody, boolean hasEngine) {
        this.rocket = rocket;
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
        if (!hasbody) {
            tempstring += "You notice the body is missing.\n";
            RocketBody body = getBody(actor);
            if (body != null) {
                putbody = true;
                actor.removeItemFromInventory(body);
                tempstring += "You attach the body to the launchpad.\n";
            } else {
                tempstring += "You still need to find the body.\n";
            }
        }
        if (!hasengine) {
            tempstring += "You notice the engine is missing.\n";
            RocketEngine engine = getEngine(actor);
            if (engine != null) {
                putengine = true;
                actor.removeItemFromInventory(engine);
                tempstring += "You attach the engine to the launchpad.\n";
            } else {
                tempstring += "You still need to find the engine.\n";
            }
        }
        if (hasbody && hasengine) {
            tempstring += "The rocket is already finished.\n";
        }
        Rocket theRocket = (Rocket) actor;
        theRocket.setBody(putbody);
        theRocket.setEngine(putengine);
        if (putbody && putengine) {
            tempstring += "Woo, the rocket is finished.\nYou get in the rocket, and it explodes in a spectacular manner.\nTo be fair you put it together in like 5 minutes, craftsmanship isn't your forte.\nAs far as the game is concerned though, YOU'RE WINNER!\n";
            map.removeActor(actor);
        }

        return tempstring;
    }

    /**
     * Get the rocket body from the actor inventory
     *
     * @param actor To get inventory item from
     * @return RocketBody
     */
    private RocketBody getBody(Actor actor) {
        List<Item> inventory = actor.getInventory();
        for (Item item : inventory) {
            if (item instanceof RocketBody) {
                // A rocket plan item is in the inventory
                return (RocketBody) item;
            }
        }
        return null;
    }

    /**
     * Get the rocket engine from the actor inventory
     *
     * @param actor To get inventory item from
     * @return RocketEngine
     */
    private RocketEngine getEngine(Actor actor) {
        List<Item> inventory = actor.getInventory();
        for (Item item : inventory) {
            if (item instanceof RocketEngine) {
                // A rocket plan item is in the inventory
                return (RocketEngine) item;
            }
        }
        return null;
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
