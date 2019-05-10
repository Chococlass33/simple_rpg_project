package game.Items;

import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.Item;
import game.DisplayCharacters;

/**
 * Quest Item. Engine of the rocket.
 */
public class RocketEngine extends Item {
    /**
     * Create a rocket engine object
     */
    public RocketEngine() {
        super("Rocket Engine", DisplayCharacters.ROCKET_ENGINE);
        allowableActions.clear();
        allowableActions.add(new DropItemAction(this));
    }
}
