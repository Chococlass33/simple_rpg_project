package game.actions;

import edu.monash.fit2099.engine.*;
import game.items.RocketPlans;

import java.util.List;
/**
 * The actor talks to a giver of a conversation.
 */
public class TalkAction extends Action {

    private Actor giver;
    /**
     * Construct a Talk action
     *
     * @param giver Actor to give talk to.
     */
    public TalkAction(Actor giver)
    {
        this.giver = giver;
    }
    /**
     * An actor talks to a giver, Q
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return A description of the action's outcome.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        List<Item> inventory = actor.getInventory();
        String tempstring = actor + " talks to " + giver +".\n";
        if(inventory.contains(new RocketPlans()))
        {
            tempstring += "'Hand them over, I don't have all day!' " + giver +" exclaims.\n";
        }
        else
        {
            tempstring += "'I can give you something that will help, but I’m going to need the plans.' " + giver +" exclaims.\n";
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
        return actor + " talks to " + giver;
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
