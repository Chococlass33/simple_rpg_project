package game.Items;

import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.Item;
import game.DisplayCharacters;

/**
 * A Key Item. Has a color with a corresponding door. Is needed to open said door.
 */
public class Key extends Item {
    private DisplayCharacters.colour keyColour;

    /**
     * Constructs a Key object. With the color parameter, you can specify which color to use without incrementing the counter.
     */
    public Key(DisplayCharacters.colour colour) {
        super(colour + " Key", DisplayCharacters.KEY);
        keyColour = colour;
        makeDroppable();
    }

    /**
     * Make it so the key can be dropped on character K/O
     */
    private void makeDroppable() {
        allowableActions.clear();
        allowableActions.add(new DropItemAction(this));
    }

    /**
     * Get the colour of the key
     * @return Key colour
     */
    public DisplayCharacters.colour getColour() {
        return keyColour;
    }

}
