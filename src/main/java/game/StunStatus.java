package game;

import edu.monash.fit2099.engine.Action;

import java.util.Optional;

public class StunStatus extends StatusEffect {

    public StunStatus(int duration) {
        super(duration, "Stun Status");
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
