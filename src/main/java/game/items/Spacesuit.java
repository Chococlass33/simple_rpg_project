package game.items;

import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.Item;
import game.DisplayCharacters;

/**
 * Quest Item. A spacesuit that prevent suffocation.
 */
public class Spacesuit extends Item {
    /**
     * Create a spacesuit object.
     */
    public Spacesuit() {
        super("Spacesuit", DisplayCharacters.SPACE_SUIT);
        allowableActions.clear();
        allowableActions.add(new DropItemAction(this));
    }
}
