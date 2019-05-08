package game.Items;

import edu.monash.fit2099.engine.Item;
import game.DisplayCharacters;
public class Key extends Item {
    static int keyCount = 0;
    public Key() {
        super(DisplayCharacters.COLORS[keyCount %10] + " Key", DisplayCharacters.KEY);
        keyCount++;
    }

}
