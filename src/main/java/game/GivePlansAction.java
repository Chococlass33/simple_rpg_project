package game;

import edu.monash.fit2099.engine.*;

public class GivePlansAction extends Action {

    @Override
    public String execute(Actor actor, GameMap map) {
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " tries to give the rocket plans.";
    }

    @Override
    public String hotKey() {
        return "";
    }
}
