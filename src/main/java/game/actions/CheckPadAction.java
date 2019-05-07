package game.actions;

import edu.monash.fit2099.engine.*;

public class CheckPadAction extends Action {
    private Location location;
    private boolean hasbody;
    private boolean hasengine;
    public CheckPadAction(Location location, boolean hasBody, boolean hasEngine) {
        this.location = location;
        this.hasbody = hasBody;
        this.hasengine = hasEngine;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String tempstring = "You look at the pad.\n";
        if(hasbody)
        {
            tempstring += "The body is ready.\n";
        }
        else
        {
            tempstring += "The body is still needed to proceed.\n";
        }
        if(hasengine)
        {
            tempstring += "The engine is ready.\n";
        }
        else
        {
            tempstring += "The engine is still needed to proceed.\n";
        }
        return tempstring;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + "checks the rocket pad.";
    }

    @Override
    public String hotKey() {
        return "";
    }
}
