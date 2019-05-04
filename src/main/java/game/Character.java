package game;

import edu.monash.fit2099.engine.*;

import java.util.Optional;

/**
 * Character extends actors to implement functionality specific to our game.
 */
public class Character extends Actor {

    // Intrinsic damage
    private int intDamage;

    // Character controller
    private Controller characterController;

    /**
     * Constructor for character
     * @param name Name of the character
     * @param displayChar Character to use for displaying the character
     * @param priority Priority order
     * @param hitPoints Hit points for the character
     * @param controller The controller for the character
     */
    public Character(Controller controller, String name, char displayChar, int priority, int hitPoints) {
        super(name, displayChar, priority, hitPoints);
        characterController = controller;
        intDamage = 5;
    }

    /**
     * Constructor for character
     * @param controller The controller for the character
     * @param name Name of the character
     * @param displayChar Character to use for displaying the character
     * @param priority Priority order
     * @param hitPoints Hit points for the character
     * @param intDamage Unarmed character damage
     */
    public Character(Controller controller, String name, char displayChar, int priority, int hitPoints, int intDamage) {
        super(name, displayChar, priority, hitPoints);
        characterController = controller;
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

    /**
     * Get the characters name
     * @return The name of the character
     */
    public String getName() {
        return name;
    }

    /**
     * Play the character turn
     *
     * @param actions collection of possible Actions for this Actor
     * @param map the map containing the Actor
     * @param display the I/O object to which messages may be written
     * @return the Action to be performed
     */
    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {

        // Get the character's action from the controller
        Optional<Action> action = characterController.selectedAction(this, actions, map, display);

        // Return the action or skip the turn if no action is provided
        return action.orElseGet(() -> super.playTurn(actions, map, display));
    }

}
