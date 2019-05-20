package game.behaviours;

import edu.monash.fit2099.engine.*;
import game.items.OxygenTank;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Produce an oxygen tank.
 */
public class DispenseOxygenBehaviour implements ActionFactory {
    private Random rand = new Random();

    /**
     * Return a moveActor action if the random space chosen is able to be entered.
     * @param actor actor with the behaviour.
     * @param map game map containing the actor.
     * @return Either null or a StunAction.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Optional<OxygenTank> tank = getTank(actor);
        if (tank.isPresent()) {
            Location here = map.locationOf(actor);
            int randomExit = rand.nextInt(here.getExits().size());
            for (Exit exit : here.getExits()) {
                Location destination = exit.getDestination();
                if (here.getExits().indexOf(exit) == randomExit && destination.canActorEnter(actor)) {
                    return new DropItemAction(tank.get());
                }
            }
        }
        return null;
    }

    /**
     * Get an oxygen tank from the actor's inventory.
     * @param actor Atory inventory holding he tank.
     * @return Optional oxygen tank.
     */
    private Optional<OxygenTank> getTank(Actor actor) {
        List<Item> inventory = actor.getInventory();
        for (Item item : inventory) {
            if (item instanceof OxygenTank) {
                // A oxygen tank item is in the inventory
                return Optional.of((OxygenTank) item);
            }
        }
        return Optional.empty();
    }
}
