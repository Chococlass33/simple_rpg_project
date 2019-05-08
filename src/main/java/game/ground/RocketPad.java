package game.ground;

import edu.monash.fit2099.engine.*;
import game.DisplayCharacters;
import game.actions.PlacePartAction;
import game.actions.CheckPadAction;

/**
 * A Rocket Pad. Can be inspected, and parts can be added to it. If both body and engine are attached you win.
 */
public class RocketPad extends Ground {
    private boolean hasBody;
    private boolean hasEngine;
    /**
     * Construct a RocketPad. With no parameters, the rocketpad had no parts.
     */
    public RocketPad() {
        super(DisplayCharacters.ROCKET_PAD);
        this.hasBody = false;
        this.hasEngine = false;
    }
    /**
     * Construct a RocketPad. Using the parameter, you can create this with parts.
     * Useful for actions that replace the pad with another version with the parts attached.
     * @param hasBody   Boolean representing the presence of a body.
     * @param hasEngine   Boolean representing the presence of an engine.
     */
    public RocketPad(boolean hasBody,boolean hasEngine) {
        super(DisplayCharacters.ROCKET_PAD);
        this.hasBody = hasBody;
        this.hasEngine = hasEngine;
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
     * Returns a list of actions given by this ground object.
     * @param actor Actor to be given the action
     * @param location Location of the action
     * @param direction Unused, String representing the direction faced.
     * @return Actions, a wrapper holding the given actions. In this case, the pad will give an PlacePartAction and CheckPadAction.
     */
    @Override
    public Actions allowableActions(Actor actor, Location location, String direction){
        Actions temp = new Actions(new PlacePartAction(location, hasBody, hasEngine));
        temp.add(new CheckPadAction(location, hasBody, hasEngine));
        return temp;
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
