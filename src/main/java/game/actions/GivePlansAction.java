package game.actions;

import edu.monash.fit2099.engine.*;
import game.Items.RocketBody;
import game.Items.RocketPlans;

import java.util.List;
/**
 * The actor gives plans to a specified taker, should be Q.
 */
public class GivePlansAction extends Action {

    private Actor taker;
    /**
     * Construct a GivePlan action
     *
     * @param taker Actor to give the plans to.
     */
    public GivePlansAction(Actor taker) {
        this.taker = taker;
    }

    /**
     * An actor tries to give the rocket plans to a taker.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return A description of the action's outcome.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
            List<Item> inventory = actor.getInventory();
            String tempstring = actor + " tries to give " + taker + " the plans.\n";
            if(inventory.contains(new RocketPlans()))
            {
                inventory.remove(new RocketPlans());
                inventory.add(new RocketBody());
                tempstring += "'WOWEE those plans look mighty juicy. Here, I'll just leave you this rocket body.uwu' " + taker +" exclaims.\n" + actor + " gets the rocket body.";
                map.removeActor(taker);
            }
            else
            {
                tempstring += "Too bad " + actor + " doesn't have the plans right now. Should be in some locked area somewhere.owo";
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
        return actor + " gives plans to " + taker;
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
