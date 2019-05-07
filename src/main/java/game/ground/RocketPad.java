package game.ground;

import edu.monash.fit2099.engine.*;
import game.DisplayCharacters;
import game.actions.PlacePartAction;
import game.actions.CheckPadAction;


public class RocketPad extends Ground {
    private boolean hasBody;
    private boolean hasEngine;
    public RocketPad() {
        super(DisplayCharacters.ROCKET_PAD);
        this.hasBody = false;
        this.hasEngine = false;
    }
    public RocketPad(boolean hasBody,boolean hasEngine) {
        super(DisplayCharacters.ROCKET_PAD);
        this.hasBody = hasBody;
        this.hasEngine = hasEngine;
    }
    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }

    @Override
    public Actions allowableActions(Actor actor, Location location, String direction){
        Actions temp = new Actions(new PlacePartAction(location, hasBody, hasEngine));
        temp.add(new CheckPadAction(location, hasBody, hasEngine));
        return temp;
    }

    @Override
    public boolean blocksThrownObjects() {
        return true;
    }
}
