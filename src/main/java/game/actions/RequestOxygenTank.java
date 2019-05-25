package game.actions;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import game.items.OxygenTank;

/**
 * The actor requests an oxygen tank.
 */
public class RequestOxygenTank extends Action {

    private Actor dispenser;

    /**
     * Request an oxygen tank.
     * @param dispenser The dispenser of the oxygen tank.
     */
    public RequestOxygenTank(Actor dispenser) {
        this.dispenser = dispenser;
    }

    /**
     * An actor requests an oxygen tank.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return A description of the action's outcome.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        dispenser.addItemToInventory(new OxygenTank(10));
        return dispenser + " hisses loudly.";
    }

    /**
     * How the action is described in a menu.
     *
     * @param actor The actor performing the action.
     * @return String of action desciption.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " requests an oxygen tank.";
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
