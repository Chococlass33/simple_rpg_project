package game.status;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Display;
import game.characters.Character;

import java.util.Optional;

/**
 * Abstract class for all status effects.
 */
public abstract class StatusEffect {

    // Name of effect
    private String effectName;

    // Effect duration
    private int effectDuration;

    // First time boolean
    private boolean firstTime = true;

    // Effect removed
    private boolean effectRemoved = false;

    /**
     * Create a new status effect
     * @param duration How many turns the status effect will last
     */
    StatusEffect(int duration, String effectName) {
        effectDuration = duration;
        this.effectName = effectName;
    }

    /**
     * Things to do when the effect is execute for the first time. By default does not nothing special first time.
     */
    protected void performFirstTime(Character subject) {
        firstTime = false;
    }

    /**
     * Remove any lingering effects of a status effect.
     */
    public void performRemoval(Character subject) {
        if (!effectRemoved) {
            removalAction(subject);
        }
        effectRemoved = true;
    }

    /**
     * The action to take to remove a status effect.
     * @param subject The subject to remove the effect from.
     */
    protected void removalAction(Character subject) {
        effectRemoved = true;
    }

    /**
     * The specific behaviour of the status effect
     * @param subject The character to apply the effect to
     * @return An optional action.
     */
    protected abstract Optional<Action> executeEffect(Character subject, Display display);

    /**
     * Trigger the status effect on a character
     * @param subject The subject of the status effect
     * @return An optional action.
     */
    public Optional<Action> performStatusEffect(Character subject, Display display) {
        effectDuration -= 1;
        if (!isExpired()) {
            if (firstTime) {
                performFirstTime(subject);
                firstTime = false;
            }
            return executeEffect(subject, display);
        } else {
            // Remove any residual effects from the character
            performRemoval(subject);
            return Optional.empty();
        }
    }

    /**
     * Check if the status effect has expired
     * @return True if expired false if still active
     */
    public boolean isExpired() {
        return effectDuration < 0;
    }

    /**
     * Get the name of the status effect
     * @return The effect name
     */
    public String getEffectName() {
        return effectName;
    }
}
