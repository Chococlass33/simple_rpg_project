package game.ground;

import edu.monash.fit2099.engine.*;
import game.DisplayCharacters;
import game.actions.UnlockedDoorAction;


public class UnlockedDoor extends Ground {
    private String color;
    public UnlockedDoor(String color) {
        super(DisplayCharacters.UNLOCKED_DOOR);
        this.color = color;

    }
    @Override
    public boolean canActorEnter(Actor actor) {
        return true;
    }

    @Override
    public Actions allowableActions(Actor actor, Location location, String direction){
        return new Actions(new UnlockedDoorAction(location,color,true));
    }

    @Override
    public boolean blocksThrownObjects() {
        return true;
    }
}
