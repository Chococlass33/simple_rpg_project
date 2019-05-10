package game.ground;

import edu.monash.fit2099.engine.*;
import game.DisplayCharacters;
import game.actions.UnlockedDoorAction;

/**
 * A Locked Door. Has a color with a corresponding key. Cannot be passed. Can be unlocked using the UnlockedDoorAction by an actor with the right key.
 */
public class LockedDoor extends Ground {
    private DisplayCharacters.colour color;

    /**
     * Construct a LockedDoor. Using the parameter, you can create this door without incrementing the counter.
     * Useful for actions that replace another ground object with this door.
     * @param color   String representing the color of the door.
     */
    public LockedDoor(DisplayCharacters.colour color) {
        super(DisplayCharacters.LOCKED_DOOR);
        this.color = color;
    }
    /**
     * Checks to see if actors can pass through.
     *
     * @return false, the locked door cannot be passed through.
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
     * @return Actions, a wrapper holding the given actions. In this case, the door will give an UnlockedDoor action.
     */
    @Override
    public Actions allowableActions(Actor actor, Location location, String direction){
        return new Actions(new UnlockedDoorAction(location, color,false));
    }

    /**
     * Checks to see if thrown objects can go through.
     *
     * @return true, the locked door can block thrown objects.
     */
    @Override
    public boolean blocksThrownObjects() {
        return true;
    }
}
