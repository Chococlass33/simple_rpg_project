package game.items;

import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.Item;
import game.DisplayCharacters;
import game.actions.ShootWaterAction;

/**
 * Quest Item. Used to destroy the exoskeleton.
 */
public class WaterGun extends Item {
    private boolean filled;
    /**
     * Create a WaterGun object
     */
    public WaterGun() {
        super("Water Gun", DisplayCharacters.WATERGUN);
        allowableActions.add(new ShootWaterAction(this));
        filled = false;
    }

    public boolean getFilled(){
        return filled;
    }

    public void unfill(){
        filled = false;
    }

    public void fill(){
        filled = true;
    }
}
