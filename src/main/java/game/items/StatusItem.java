package game.items;

import edu.monash.fit2099.engine.Item;
import game.status.StatusEffect;

/**
 * An item that applies a status effect when held by a character.
 */
public abstract class StatusItem extends Item {


    /**
     * Build a status item.
     * @param name The name of the item.
     * @param displayChar The character to use when the item is dropped.
     */
    public StatusItem(String name, char displayChar) {
        super(name, displayChar);
    }

    /**
     * Get the status effect associated with this item.
     * @return A status effect.
     */
    public abstract StatusEffect getEffect();

}
