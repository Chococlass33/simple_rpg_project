package game;

import edu.monash.fit2099.engine.Action;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

/**
 * Abstract class for all status effects.
 */
public abstract class StatusEffect {

    private Logger logger = LogManager.getLogger(this.getClass());

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
    protected abstract Optional<Action> executeEffect(Character subject);

    /**
     * Trigger the status effect on a character
     * @param subject The subject of the status effect
     * @return An optional action.
     */
    Optional<Action> performStatusEffect(Character subject) {
        effectDuration -= 1;
        if (!isExpired()) {
            logger.debug("Character: {} | Status : {} | Executed status effect", subject.getName(), effectName);
            return executeEffect(subject);
        } else {
            logger.debug("Character: {} | Status : {} | Has expired", subject.getName(), effectName);
            return Optional.empty();
        }
    }

    /**
     * Check if the status effect has expired
     * @return True if expired false if still active
     */
    boolean isExpired() {
        return effectDuration < 0;
    }

    /**
     * Get the name of the status effect
     * @return The effect name
     */
    String getEffectName() {
        return effectName;
    }
}
