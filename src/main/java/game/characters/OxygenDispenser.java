package game.characters;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import game.DisplayCharacters;
import game.actions.RequestOxygenTank;
import game.actions.TakeItemAction;
import game.behaviours.StandStillBehaviour;
import game.controllers.LoopingController;
import game.items.OxygenTank;
import game.items.Spacesuit;

import java.util.List;
import java.util.Optional;

/**
 * An oxygen dispenser. Drops oxygen a turn after being asked to.
 */
public class OxygenDispenser extends Character {

    /**
     * Construct an oxygen dispenser.
     *
     */
    public OxygenDispenser() {
        super(new LoopingController(new StandStillBehaviour()), "Oxygen Dispenser", DisplayCharacters.OXYGEN_DISPENSER, 4, 9999);
    }
    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        Actions tempActions = new Actions();
        Optional<OxygenTank> oxygenTank = getTank(this);
        if (!oxygenTank.isPresent()) {
            tempActions.add(new RequestOxygenTank(this));
        } else {
            tempActions.add(new TakeItemAction(this, oxygenTank.get()));
        }
        tempActions.add(new TakeItemAction(this, new Spacesuit()));
        return tempActions;
    }

    /**
     * Get an oxygen tank from the actor's inventory.
     * @param actor Actor inventory holding he tank.
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
