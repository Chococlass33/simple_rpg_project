package game.characters;

import edu.monash.fit2099.engine.Actor;
import game.DisplayCharacters;
import game.behaviours.FollowBehaviour;
import game.controllers.LoopingController;
import game.items.ExoSkeleton;

/**
 * A boss character. Starts with an exoskeleton.
 */
public class YugoMaxx extends Character {

    /**
     * Create Yugo Max. Set the to target another character.
     * @param target Actor to target
     */
    public YugoMaxx(Actor target) {
        super(new LoopingController(new FollowBehaviour(target)), "Yugo Maxx", DisplayCharacters.YUGO_MAXX, 10, 50, 10);
        addItemToInventory(new ExoSkeleton());
    }

}
