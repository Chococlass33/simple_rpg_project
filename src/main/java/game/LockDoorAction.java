package game;

import edu.monash.fit2099.engine.*;

import java.util.List;

public class LockDoorAction extends Action {
    private boolean isUnlocked;
    private Location doorLocation;
    private String color;
    public LockDoorAction(Location doorLocation, String color,boolean isUnlocked) {
        this.doorLocation = doorLocation;
        this.color = color;
        this.isUnlocked = isUnlocked;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        List<Item> inventory = actor.getInventory();
        if(inventory.contains(new Item(color + " Key",'*')))
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
