package game.Items;

import edu.monash.fit2099.engine.Item;
import game.DisplayCharacters;

/**
 * A Key Item. Has a color with a corresponding door. Is needed to open said door. Has a counter that helps determine the color.
 */
public class Key extends Item {
    private static int keyCount = 0;
    /**
     * Constructs a Key object. With no parameters, it will  generate a color based on the counter and increment the static counter.
     */
    public Key() {
        super(DisplayCharacters.COLORS[keyCount %10] + " Key", DisplayCharacters.KEY);
        keyCount++;
    }
    /**
     * Constructs a Key object. With the color parameter, you can specify which color to use without incrementing the counter.
     */
    public Key(String color) {
        super(color + " Key", DisplayCharacters.KEY);
    }

}
