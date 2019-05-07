package game.behaviours;

import edu.monash.fit2099.engine.*;
import game.behaviours.ActionFactory;

import java.util.Random;
public class WanderingBehaviour implements ActionFactory {
    private Random rand = new Random();
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
