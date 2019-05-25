package game.items;

import game.DisplayCharacters;
import game.status.ArmouredStatus;
import game.status.StatusEffect;

/**
 * An item that applies a massive armour boost to the character.
 */
public class ExoSkeleton extends StatusItem {


    /**
     * Build an exoskeleton
     */
    public ExoSkeleton() {
        super("ExoSkeleton", DisplayCharacters.EXOSKELETON);
    }

    /**
     * Get the status effect associated with this item.
     * @return A strong armoured effect.
     */
    @Override
    public StatusEffect getEffect() {
        return new ArmouredStatus(1, 100000000);
    }

}
