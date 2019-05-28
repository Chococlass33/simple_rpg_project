package game.characters;

import game.DisplayCharacters;
import game.behaviours.WanderingBehaviour;
import game.controllers.LoopingController;
import game.items.ExoSkeleton;

/**
 * A boss character. Starts with an exoskeleton.
 */
public class YugoMaxx extends Character {

    /**
     * Create Yugo Max.
     */
    public YugoMaxx() {
        super(new LoopingController(new WanderingBehaviour()), "Yugo Maxx", DisplayCharacters.YUGO_MAXX, 10, 50, 10);
        addItemToInventory(new ExoSkeleton());
    }

}
