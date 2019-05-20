package game.items;

import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.Item;
import game.DisplayCharacters;

/**
 * Quest Item. A spacesuit that prevent suffocation.
 */
public class Spacesuit extends Item {

    private OxygenTank oxygenTank = null;

    /**
     * Create a spacesuit object.
     */
    public Spacesuit() {
        super("Spacesuit", DisplayCharacters.SPACE_SUIT);
        allowableActions.clear();
        allowableActions.add(new DropItemAction(this));
    }

    /**
     * Attach an oxygen tank to the spacesuit.
     * @param tank Tank filled with oxygen.
     */
    public void attachOxygenTank(OxygenTank tank) {
        oxygenTank = tank;
    }

    /**
     * Take a breath.
     * @return True if there is oxygen. False if there is not.
     */
    public boolean breath() {
        return oxygenTank != null && oxygenTank.consumeOxygen();
    }

    /**
     * Get the amount of oxygen in the current tank
     * @return Oxygen remaining
     */
    public int remainingOxygen() {
        if (oxygenTank != null) {
            return oxygenTank.getOxygenStored();
        } else {
            return 0;
        }
    }
}
