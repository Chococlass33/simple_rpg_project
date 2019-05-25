package game.characters;

import edu.monash.fit2099.engine.Actor;
import game.DisplayCharacters;
import game.behaviours.InsultBehaviour;
import game.behaviours.FollowBehaviour;
import game.controllers.LoopingController;

/**
 * More powerful grunt. Can also insult another character.
 */
public class Goon extends Character {

    /**
     * Create a goon. Set the to target another character.
     * @param name Goon name
     * @param target Actor to target
     */
    public Goon(String name, Actor target) {
        super(new LoopingController(new InsultBehaviour(target), new FollowBehaviour(target)), name, DisplayCharacters.GOON, 10, 50, 10);
    }

}
