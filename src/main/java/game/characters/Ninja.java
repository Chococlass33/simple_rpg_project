package game.characters;

import game.DisplayCharacters;
import game.behaviours.RetreatBehaviour;
import game.behaviours.StandStillBehaviour;
import game.behaviours.StunBehaviour;
import game.controllers.LoopingController;

/**
 * A Ninja. Will attempt to maintain a minimum distance from the target. If cornered will attempt to stun the target.
 */
public class Ninja extends Character {

    /**
     * Construct a Ninja.
     *
     * @param name   Ninja name.
     * @param target The target of the ninja.
     */
    public Ninja(String name, Character target) {

        super(new LoopingController(new RetreatBehaviour(target, 5), new StunBehaviour(target, 5, 2), new StandStillBehaviour()), name, DisplayCharacters.NINJA, 6, 5);
    }
}
