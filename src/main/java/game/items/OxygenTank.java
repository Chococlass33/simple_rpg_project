package game.items;

import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.Item;
import game.DisplayCharacters;

/**
 * A tank filled with oxygen.
 */
public class OxygenTank extends Item {

    private int oxygenStored;

    /**
     * Create an oxygen tank object.
     */
    public OxygenTank(int storedOxygen) {
        super("Oxygen Tank", DisplayCharacters.OXYGEN_TANK);
        oxygenStored = storedOxygen;
        allowableActions.clear();
        allowableActions.add(new DropItemAction(this));
    }

    /**
     * Return how much oxygen is stored in the tank.
     * @return Integer of oxygen stored.
     */
    public int getOxygenStored() {
        return oxygenStored;
    }

    /**
     * Consume a unit of oxygen from the tank. Reduces the stored oxygen count.
     * @return True if oxygen can be consumed, false if no oxygen remains.
     */
    public boolean consumeOxygen() {
        oxygenStored -= 1;
        return oxygenStored > 0;
    }
}
