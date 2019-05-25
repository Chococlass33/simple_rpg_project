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

    /**
     * Create a new status effect
     * @param duration How many turns the status effect will last
     */
    StatusEffect(int duration, String effectName) {
        effectDuration = duration;
        this.effectName = effectName;
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
            return executeEffect(subject, display);
        } else {
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
