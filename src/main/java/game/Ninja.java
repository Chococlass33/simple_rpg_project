package game;

/**
 * A Ninja. Will either stun the player or retreat
 */
public class Ninja extends Character {

    /**
     * Construct a Ninja.
     *
     * @param name   Ninja name.
     * @param target The target of the ninja.
     */
    public Ninja(String name, Character target) {

        super(new LoopingController(new RetreatBehaviour(target, 5), new StunBehaviour(target, 5, 2), new StandStillBehaviour()), name, 'N', 6, 5);
    }
}
