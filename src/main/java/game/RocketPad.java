package game;

import edu.monash.fit2099.engine.*;


public class RocketPad extends Ground {
    private boolean hasBody;
    private boolean hasEngine;
    public RocketPad() {
        super('@');
        this.hasBody = false;
        this.hasEngine = false;
    }
    public RocketPad(boolean hasBody,boolean hasEngine) {
        super('@');
        this.hasBody = hasBody;
        this.hasEngine = hasEngine;
    }
    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }

    @Override
    public Actions allowableActions(Actor actor, Location location, String direction){
        Actions temp = new Actions(new PutItems(location, hasBody, hasEngine));
        temp.add(new checkPad(location, hasBody, hasEngine));
        return temp;
    }

    @Override
    public boolean blocksThrownObjects() {
        return true;
    }
}
