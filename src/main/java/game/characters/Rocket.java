package game.characters;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import game.DisplayCharacters;
import game.actions.*;
import game.behaviours.RetreatBehaviour;
import game.behaviours.StandStillBehaviour;
import game.behaviours.StunBehaviour;
import game.controllers.LoopingController;

/**
 * A Ninja. Will attempt to maintain a minimum distance from the target. If cornered will attempt to stun the target.
 */
public class Rocket extends Character {


    private Actor rocket;
    private GameMap map;
    private boolean hasBody;
    private boolean hasEngine;

    /**
     * Construct a Rocket, pointing to a rocket and the map it's on.
     *
     * @param rocket the rocket to point to.
     * @param map    The map to point to.
     */
    public Rocket(Rocket rocket, GameMap map) {

        super(new LoopingController(new StandStillBehaviour()), "ROCKET", DisplayCharacters.ROCKET, 6, 5);
        this.map = map;
        int x = map.locationOf(rocket).x();
        int y = map.locationOf(rocket).y();
        boolean otherbody = rocket.getBody();
        boolean otherengine = rocket.getEngine();
        map.removeActor(rocket);
        Actor newRocket = new Rocket(this, this.map, otherbody, otherengine);
        map.addActor(newRocket, x, y);
        this.rocket = newRocket;
        this.hasBody = true;
        this.hasEngine = true;
    }

    public Rocket(Rocket rocket, GameMap map, boolean hasEngine, boolean hasBody) {

        super(new LoopingController(new StandStillBehaviour()), "ROCKET", DisplayCharacters.ROCKET, 6, 5);
        this.map = map;
        int x = map.locationOf(rocket).x();
        int y = map.locationOf(rocket).y();
        boolean otherbody = rocket.getBody();
        boolean otherengine = rocket.getEngine();
        map.removeActor(rocket);
        Actor newRocket = new Rocket(this, this.map, otherbody, otherengine);
        map.addActor(newRocket, x, y);
        this.rocket = newRocket;
        this.hasBody = hasBody;
        this.hasEngine = hasEngine;
    }

    /**
     * Construct a Rocket, if there is no other rocket to point to.
     *
     * @param map The map this rocket is in.
     */
    public Rocket(GameMap map) {
        super(new LoopingController(new StandStillBehaviour()), "ROCKET", DisplayCharacters.ROCKET, 6, 5);
        this.map = map;
        this.rocket = this;
        this.hasBody = true;
        this.hasEngine = true;
    }

    public Rocket(GameMap map, boolean hasEngine, boolean hasBody) {
        super(new LoopingController(new StandStillBehaviour()), "ROCKET", DisplayCharacters.ROCKET, 6, 5);
        this.map = map;
        this.rocket = this;
        this.hasBody = hasBody;
        this.hasEngine = hasEngine;
    }

    public boolean getBody() {
        return hasBody;
    }

    public boolean getEngine() {
        return hasEngine;
    }

    public Actor getRocket() {
        return rocket;
    }

    public GameMap getMap() {
        return map;
    }

    public void setBody(boolean hasBody) {
        this.hasBody = hasBody;
    }

    public void setEngine(boolean hasEngine) {
        this.hasEngine = hasEngine;
    }

    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        if (hasEngine && hasBody) {
            return new Actions(new MoveMapAction(this.map, this.rocket));
        }
        else
        {

            Actions temp = new Actions(new PlacePartAction(this, hasBody, hasEngine));
            temp.add(new CheckPadAction(hasBody, hasEngine));
            return temp;
        }
    }
}
