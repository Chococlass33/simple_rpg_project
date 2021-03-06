package game.actions;

import edu.monash.fit2099.engine.*;
import game.items.WaterGun;

import java.util.List;

/**
 * The actor inspects the rocket
 */
public class FillWaterAction extends Action {
    /**
     * Construct a CheckPad action
     *
     */
    public FillWaterAction() {
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
        String tempstring = "You look at the water.\n";
        List<Item> inventory = actor.getInventory();
        for (Item item : inventory) {
            if (item instanceof WaterGun) {
                // if key of correct colour is found
                WaterGun temp = (WaterGun) item;
                temp.fill();
                tempstring += "You fill the water gun with water.\n";
            }
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
        return actor + " checks the rocket pad.";
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
