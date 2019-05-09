package game.behaviours;

import edu.monash.fit2099.engine.*;
import game.behaviours.ActionFactory;

import java.util.Random;
/**
 * Produce a random MoveActorAction to simulate wandering.
 */
public class WanderingBehaviour implements ActionFactory {
    private Random rand = new Random();
    /**
     * Construct a WanderingBehavior Behaviour object.
     */
    public WanderingBehaviour() {
    }

    /**
     * Return a moveActor action if the random space chosen is able to be entered.
     * @param actor actor with the behaviour.
     * @param map game map containing the actor.
     * @return Either null or a StunAction.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        int randomExit = rand.nextInt(here.getExits().size());
        for (Exit exit : here.getExits()) {
            Location destination = exit.getDestination();
            if (here.getExits().indexOf(exit) == randomExit && destination.canActorEnter(actor))
            {
                return new MoveActorAction(destination, exit.getName());
            }
        }
        return null;
    }
}
