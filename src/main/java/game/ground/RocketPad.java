package game.ground;

import edu.monash.fit2099.engine.*;
import game.DisplayCharacters;
import game.actions.PlacePartAction;
import game.actions.CheckPadAction;

/**
 * A Rocket Pad. Can be inspected, and parts can be added to it. If both body and engine are attached you win.
 */
public class RocketPad extends Ground {
    /**
     * Construct a RocketPad. With no parameters, the rocketpad had no parts.
     */
    public RocketPad() {
        super(DisplayCharacters.ROCKET_PAD);
    }
    /**
     * Checks to see if actors can pass through.
     *
     * @return false, the pad cannot be passed through.
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }


    /**
     * Checks to see if thrown objects can go through.
     *
     * @return true, the pad can block thrown objects.
     */
    @Override
    public boolean blocksThrownObjects() {
        return true;
    }
}
