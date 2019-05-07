package game;

import edu.monash.fit2099.engine.*;


public class LockedDoor extends Ground {
    private String color;
    public LockedDoor(String color) {
        super('+');
        this.color = color;

    }
    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }

    @Override
    public Actions allowableActions(Actor actor, Location location, String direction){
        return new Actions(new LockDoorAction(location, color,false));
    }

    @Override
    public boolean blocksThrownObjects() {
        return true;
    }
}
