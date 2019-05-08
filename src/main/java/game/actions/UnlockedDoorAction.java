package game.actions;

import edu.monash.fit2099.engine.*;
import game.Items.Key;
import game.ground.LockedDoor;
import game.ground.UnlockedDoor;

import java.util.List;

/**
 * The actor unlocks or locks a door.
 */
public class UnlockedDoorAction extends Action {
    private boolean isUnlocked;
    private Location doorLocation;
    private String color;
    /**
     * Construct a UnlockedDoor action
     *
     * @param doorLocation Location of the door to lock.
     * @param color String representing the color of the door.
     * @param isUnlocked Boolean switching between locking and unlocking.
     */
    public UnlockedDoorAction(Location doorLocation, String color, boolean isUnlocked) {
        this.doorLocation = doorLocation;
        this.color = color;
        this.isUnlocked = isUnlocked;
    }

    /**
     * An actor locks or unlocks a door if they have the corresponding key.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return A description of the action's outcome.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        List<Item> inventory = actor.getInventory();
        if(inventory.contains(new Key(color)))
        {
            if (isUnlocked) {
                map.add(new LockedDoor(color), doorLocation);
                return "The " + color + " door is now locked.";
            }
            else
            {
                map.add(new UnlockedDoor(color), doorLocation);
                return "The " + color + " door is now unlocked.";
            }
        }
        else
        {
            return "The door requires a " + color + " key to lock.";
        }
    }

    /**
     * How the action is described in a menu.
     *
     * @param actor The actor performing the action.
     * @return String of action desciption.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " locks the door.";
    }

    /**
     * Action hotkey.
     *
     * @return Return empty string. No dedicated hot key.
     */
    @Override
    public String hotKey() {
        return "";
    }
}
