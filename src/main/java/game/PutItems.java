package game;

import edu.monash.fit2099.engine.*;

public class PutItems extends Action {
    private Location location;
    private boolean hasbody;
    private boolean hasengine;
    public PutItems(Location location, boolean hasBody, boolean hasEngine) {
        this.location = location;
        this.hasbody = hasBody;
        this.hasengine = hasEngine;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        String tempstring = "You try to assemble the rocket.\n";
        boolean putbody = hasbody;
        boolean putengine = hasengine;
        if(!hasbody)
        {
            tempstring += "You notice the body is missing.\n";
            if(actor.getInventory().contains(new Item("Rocket Body", '$')))
            {
                putbody = true;
                actor.getInventory().remove(new Item("Rocket Body", '$'));
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
            if(actor.getInventory().contains(new Item("Rocket Engine", '^')))
            {
                putengine = true;
                actor.getInventory().remove(new Item("Rocket Engine", '^'));
                tempstring += "You attach the engine to the launchpad.\n";
            }
            else
            {
                tempstring += "You still need to find the engine.\n";
            }
        }
        if(hasbody & hasengine)
        {
            tempstring += "The rocket is already finished.\n";
        }
        map.add(new RocketPad(putbody,putengine), location);
        if(putbody & putengine)
        {
            tempstring += "Woo, the rocket is finished.\nYou get in the rocket, and it explodes in a spectacular manner.\nTo be fair you put it together in like 5 minutes, craftsmanship isn't your forte.\nAs far as the game is concerned though, YOU'RE WINNER!\n";
            map.removeActor(actor);
        }

        return tempstring;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " puts components into the launchpad.";
    }

    @Override
    public String hotKey() {
        return "";
    }
}
