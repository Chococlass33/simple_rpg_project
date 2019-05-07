package game;

import edu.monash.fit2099.engine.*;


public class UnlockedDoor extends Ground {
    private String color;
    public UnlockedDoor(String color) {
        super('-');
        this.color = color;

    }
    @Override
    public boolean canActorEnter(Actor actor) {
        return true;
    }

    @Override
    public Actions allowableActions(Actor actor, Location location, String direction){
        return new Actions(new LockDoorAction(location,color,true));
    }

    @Override
    public boolean blocksThrownObjects() {
        return true;
    }
}
