package game.behaviours;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.SkipTurnAction;

/**
 * Return a skip turn action
 */
public class StandStillBehaviour implements ActionFactory {

    /**
     * Return a skip turn action.
     * @param actor The actor with the behaviour.
     * @param map The map containing the actor.
     * @return A skip turn action.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        return new SkipTurnAction();
    }
}
