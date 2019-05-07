package game.ground;

import edu.monash.fit2099.engine.*;
import game.DisplayCharacters;
import game.actions.UnlockedDoorAction;


public class LockedDoor extends Ground {
    private String color;
    public LockedDoor(String color) {
        super(DisplayCharacters.LOCKED_DOOR);
        this.color = color;

    }
    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }

    @Override
    public Actions allowableActions(Actor actor, Location location, String direction){
        return new Actions(new UnlockedDoorAction(location, color,false));
    }

    @Override
    public boolean blocksThrownObjects() {
        return true;
    }
}
