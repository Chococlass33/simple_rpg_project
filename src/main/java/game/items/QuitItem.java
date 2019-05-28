package game.items;

import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.Item;
import game.DisplayCharacters;
import game.actions.QuitAction;
import game.actions.ShootWaterAction;

/**
 * Quest Item. Engine of the rocket.
 */
public class QuitItem extends Item {
    /**
     * Create a WaterGun object
     */
    public QuitItem() {
        super("Quit", DisplayCharacters.WATERGUN);
        allowableActions.clear();
        allowableActions.add(new QuitAction());
    }
}
