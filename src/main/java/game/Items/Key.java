package game.Items;

import edu.monash.fit2099.engine.Item;
import game.DisplayCharacters;

public class Key extends Item {
    public Key(String color) {
        super(color + " Key", DisplayCharacters.KEY);
    }
}
