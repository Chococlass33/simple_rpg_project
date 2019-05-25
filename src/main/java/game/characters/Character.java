package game.characters;

import edu.monash.fit2099.engine.*;
import game.actions.AdvancedAttackAction;
import game.items.StatusItem;
import game.status.StatusEffect;
import game.controllers.Controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Character extends actors to implement functionality specific to our game.
 */
public class Character extends Actor {


    // Intrinsic damage
    private int intDamage;

    // Character controller
    private Controller characterController;

    // Status effects on the character
    private List<StatusEffect> statusEffects = new ArrayList<>();

    // Defence stat
    private int defence = 0;

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
     * Damage the character. Damage is reduced by the character's defence stat.
     * @param points number of hitpoints to deduct.
     */
    @Override
    public void hurt(int points) {
        if (points - defence > 0) {
            // Hurt the character only if the damage is larger than the defence stat.
            super.hurt(points - defence);
        }
    }

    /**
     * Modify the defence stat of the character.
     */
    public void modifyDefence(int amountToModifyDefenceBy) {
        defence = defence + amountToModifyDefenceBy;
    }

    /**
     * Retrieve the hitpoints of the character.
     * @return The character's hitpoints.
     */
    public int getHealth() {
        return hitPoints;
    }

    /**
     * Characters will use the AdvancedAttackAction to attack each other rather than the default one.
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return Allowable actions
     */
    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        return new Actions(new AdvancedAttackAction(otherActor, this));
    }

    /**
     * Get the defence of the character.
     * @return int of defence
     */
    public int getDefence() {
        return defence;
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
        // Get any effects from status items
        getItemStatusEffects(display);
        Optional<Action> action = executeStatusEffects(display);

        if (action.isPresent()) {
            // If the status effect has an action. Force the character to perform the action.
            return action.get();
        }

        // Get the character's action from the controller
        action = characterController.selectedAction(this, actions, map, display);

        // Return the action or skip the turn if no action is provided
        return action.orElseGet(() -> super.playTurn(actions, map, display));
    }

    /**
     * Add any new status effects from items in the inventory.
     */
    private void getItemStatusEffects(Display display) {
        List<Item> inventory = getInventory();
        for (Item item : inventory) {
            if (item instanceof StatusItem) {
                StatusEffect effect = ((StatusItem) item).getEffect();
                display.println(getName() + "'s " + item + " grants an " + effect.getEffectName());
                addStatusEffect(effect);
            }
        }
    }

    /**
     * Run all the status effects on the character. If multiple status effects return actions return the last one.
     * @return Optional action.
     */
    private Optional<Action> executeStatusEffects(Display display) {

        Optional<Action> statusAction = Optional.empty();

        for (StatusEffect effect : statusEffects) {
            Optional<Action> tempAction = effect.performStatusEffect(this, display);
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
                effect.performRemoval(this);
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
    public void addStatusEffect(StatusEffect status) {
        if (!hasStatusEffect(status.getEffectName())) {
            statusEffects.add(status);
        } else {
            // Only one status effect per type is permitted. Same types will override old effects.
            removeStatusEffect(status.getEffectName());
            statusEffects.add(status);
        }
    }

    /**
     * Remove a status effect from the character.
     * @param statusEffectName String name of the status effect to remove
     */
    public void removeStatusEffect(String statusEffectName) {
        if (hasStatusEffect(statusEffectName)) {
            // If the character has the status effect
            List<StatusEffect> tempEffects = new ArrayList<>();
            for (StatusEffect effect : statusEffects) {
                if (!effect.getEffectName().equalsIgnoreCase(statusEffectName)) {
                    // Add evey status effect except the one to remove to a temp list.
                    tempEffects.add(effect);
                } else {
                    // Remove any residual effects from the status effect
                    effect.performRemoval(this);
                }
            }
            statusEffects = tempEffects;
        }
    }

    /**
     * Check if a character has a certain status effect
     * @param statusEffectName Status effect name to check for
     * @return True if the characger has it, false if they do not
     */
    public boolean hasStatusEffect(String statusEffectName) {
        for (StatusEffect effect : statusEffects) {
            if (effect.getEffectName().equalsIgnoreCase(statusEffectName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieve an item from the characters inventory based on it's class.
     * @param itemClass The class of item to retrieve.
     * @return An optional item.
     */
    public Optional<Item> getItemByClass(Class<?> itemClass) {
        List<Item> inventory = getInventory();
        for (Item item : inventory) {
            if (itemClass.isInstance(item)) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

}
