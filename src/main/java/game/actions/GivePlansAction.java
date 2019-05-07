package game.actions;

import edu.monash.fit2099.engine.*;
import game.Items.RocketBody;
import game.Items.RocketPlans;

import java.util.List;

public class GivePlansAction extends Action {

    private Actor otherActor;

    private Actor giver;
    public GivePlansAction(Actor giver) {
        this.giver = giver;
    }

        @Override
    public String execute(Actor actor, GameMap map) {
            List<Item> inventory = actor.getInventory();
            String tempstring = actor + " tries to give Q the plans.\n";
            if(inventory.contains(new RocketPlans()))
            {
                inventory.remove(new RocketPlans());
                inventory.add(new RocketBody());
                tempstring += "'WOWEE those plans look mighty juicy. Here, I'll just leave you this rocket body.uwu' Q exclaims.\n" + actor + " gets the rocket body.";
                map.removeActor(giver);
            }
            else
            {
                tempstring += "Too bad " + actor + " doesn't have the plans right now. Should be in some locked area somewhere.owo";
            }
            return tempstring;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " gives plans to " + giver;
    }

    @Override
    public String hotKey() {
        return "";
    }
}
