package game;

import edu.monash.fit2099.engine.*;

/**
 * Character extends actors to implement functionality specific to our game.
 */
public class Character extends Actor {

    // Intrinsic damage
    private int intDamage;

    /**
     * Constructor for character
     * @param name Name of the character
     * @param displayChar Character to use for displaying the character
     * @param priority Priority order
     * @param hitPoints Hit points for the character
     */
    public Character(String name, char displayChar, int priority, int hitPoints) {
        super(name, displayChar, priority, hitPoints);
        intDamage = 5;
    }

    /**
     * Constructor for character
     * @param name Name of the character
     * @param displayChar Character to use for displaying the character
     * @param priority Priority order
     * @param hitPoints Hit points for the character
     * @param intDamage Unarmed character damage
     */
    public Character(String name, char displayChar, int priority, int hitPoints, int intDamage) {
        super(name, displayChar, priority, hitPoints);
        this.intDamage = intDamage;
    }

    /**
     * Creates and returns an intrinsic weapon based on character intDamage
     *
     * @return a freshly-instantiated IntrinsicWeapon
     */
    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(intDamage, "punches");
    }

}
