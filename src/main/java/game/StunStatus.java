package game;

import edu.monash.fit2099.engine.Action;

import java.util.Optional;

/**
 * A status effect for stunned characters
 */
public class StunStatus extends StatusEffect {

    public static final String STUN_STATUS = "Stun Status";

    /**
     * Create a stun status
     * @param duration How long the status will last
     */
    public StunStatus(int duration) {
        super(duration, STUN_STATUS);
    }

    /**
     * Return a stunned action
     * @param subject The character to apply the effect to
     * @return stunned action
     */
    @Override
    protected Optional<Action> executeEffect(Character subject) {
        return Optional.of(new StunnedAction());
    }
}
