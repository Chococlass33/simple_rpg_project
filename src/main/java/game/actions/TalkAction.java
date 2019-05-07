package game.actions;

import edu.monash.fit2099.engine.*;
import game.Items.RocketPlans;

import java.util.List;

public class TalkAction extends Action {

    private Actor giver;

    public TalkAction(Actor giver)
    {
        this.giver = giver;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        List<Item> inventory = actor.getInventory();
        String tempstring = actor + " talks to " + giver +".\n";
        if(inventory.contains(new RocketPlans()))
        {
            tempstring += "'Hand them over, I don't have all day! owo' " + giver +" exclaims.\n";
        }
        else
        {
            tempstring += "'I can give you something that will help, but I’m going to need the plans. uwu' " + giver +" exclaims.\n";
        }
        return tempstring;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + "talks to " + giver;
    }

    @Override
    public String hotKey() {
        return "";
    }
}
