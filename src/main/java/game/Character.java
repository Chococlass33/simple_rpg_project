package game;

import edu.monash.fit2099.engine.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Character extends actors to implement functionality specific to our game.
 */
public class Character extends Actor {

    private Logger logger = LogManager.getLogger(this.getClass());

    // Intrinsic damage
    private int intDamage;

    // Character controller
    private Controller characterController;

    // Status effects on the character
    private List<StatusEffect> statusEffects = new ArrayList<>();

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

        // Apply status effects
        clearExpiredStatusEffects();
        Optional<Action> action = executeStatusEffects();

        if (action.isPresent()) {
            // If the status effect has an action. Force the character to perform the action.
            logger.debug("Character: {} | Forced Action: {}", getName(), action.get().getClass().getSimpleName());
            return action.get();
        }

        // Get the character's action from the controller
        action = characterController.selectedAction(this, actions, map, display);

        // Return the action or skip the turn if no action is provided
        return action.orElseGet(() -> super.playTurn(actions, map, display));
    }

    /**
     * Run all the status effects on the character. If multiple status effects return actions return the last one.
     * @return Optional action.
     */
    private Optional<Action> executeStatusEffects() {

        Optional<Action> statusAction = Optional.empty();

        for (StatusEffect effect : statusEffects) {
            Optional<Action> tempAction = effect.performStatusEffect(this);
            if (tempAction.isPresent()) {
                statusAction = tempAction;
            }
        }

        return statusAction;
    }

    /**
     * Clear any expired status effects from the character.
     */
    private void clearExpiredStatusEffects() {

        List<StatusEffect> validEffects = new ArrayList<>();

        // Check for expired status effects
        for (StatusEffect effect : statusEffects) {
            if (effect.isExpired()) {
                logger.debug("Character: {} | Status effect expired: {}", getName(), effect.getEffectName());
            } else {
                validEffects.add(effect);
            }
        }

        // Set the character to only contain valid status effects
        statusEffects = validEffects;
    }

    /**
     * Add a status effect to the character
     * @param status The status effect to add
     */
    void addStatusEffect(StatusEffect status) {
        logger.debug("Character: {} | Status effect applied: {}", getName(), status.getEffectName());
        statusEffects.add(status);
    }

}
