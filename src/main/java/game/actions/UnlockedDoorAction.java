package game.actions;

import edu.monash.fit2099.engine.*;
import game.Items.Key;
import game.ground.LockedDoor;
import game.ground.UnlockedDoor;

import java.util.List;

public class UnlockedDoorAction extends Action {
    private boolean isUnlocked;
    private Location doorLocation;
    private String color;
    public UnlockedDoorAction(Location doorLocation, String color, boolean isUnlocked) {
        this.doorLocation = doorLocation;
        this.color = color;
        this.isUnlocked = isUnlocked;
    }

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

    @Override
    public String menuDescription(Actor actor) {
        return actor + " locks the door.";
    }

    @Override
    public String hotKey() {
        return "";
    }
}
