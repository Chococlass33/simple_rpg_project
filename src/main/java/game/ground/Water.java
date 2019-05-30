package game.ground;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;
import game.DisplayCharacters;
import game.actions.FillWaterAction;
import game.actions.UnlockedDoorAction;

/**
 * A water tile. Can't be walked on but can be used to fill the water gun.
 */
public class Water extends Ground {

    /**
     * Constructor for water.
     */
    public Water() {
        super(DisplayCharacters.WATER);
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
        return new Actions(new FillWaterAction());
    }

    /**
     * Checks to see if thrown objects can go through.
     *
     * @return true, the locked door can block thrown objects.
     */
    @Override
    public boolean blocksThrownObjects() {
        return false;
    }
}
