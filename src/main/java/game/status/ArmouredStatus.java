package game.status;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Display;
import game.characters.Character;

import java.util.Optional;

/**
 * A status effect to boost the defence stat of a character.
 */
public class ArmouredStatus extends StatusEffect {

    public static final String ARMOURED_STATUS = "Armoured Status";
    private int armourStrength;

    /**
     * Create an armoured status.
     * @param duration How long the status will last.
     */
    public ArmouredStatus(int duration, int armourStrength) {
        super(duration, ARMOURED_STATUS);

        // Set armour strength. Minimum accepted strength of 1
        if (armourStrength > 0) {
            this.armourStrength = armourStrength;
        } else {
            this.armourStrength = 0;
        }
    }

    /**
     * Do nothing.
     * @param subject The character to apply the effect to
     * @return Empty optional.
     */
    @Override
    protected Optional<Action> executeEffect(Character subject, Display display) {
        return Optional.empty();
    }


    /**
     * When effect is removed reduce the defence stat by the amount of armour originally applied.
     * @param subject Subject to restore to previous state.
     */
    @Override
    public void removalAction(Character subject) {
        subject.modifyDefence(armourStrength * -1);
    }

    /**
     * On first execution boost the subject's defence stat by the amount of armour.
     * @param subject Subject to boost.
     */
    @Override
    protected void performFirstTime(Character subject) {
        subject.modifyDefence(armourStrength);
    }
}
