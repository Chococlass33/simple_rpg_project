package game.actions;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

/**
 * The actor takes an item from another actors inventory
 */
public class TakeItemAction extends Action {

    private Item item;
    private Actor target;

    /**
     * Construct the option to take an item from another's inventory
     * @param itemToTake Item to take from the  inventory
     */
    public TakeItemAction(Actor target,Item itemToTake) {
        item = itemToTake;
        this.target = target;
    }

    /**
     * An actor takes another actors item.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return A description of the action's outcome.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        actor.addItemToInventory(item);
        target.removeItemFromInventory(item);
        return actor + " takes " + item + " from " + target;
    }

    /**
     * How the action is described in a menu.
     *
     * @param actor The actor performing the action.
     * @return String of action desciption.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " takes " + item;
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
