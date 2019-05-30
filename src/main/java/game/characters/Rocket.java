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
 * A rocket character. Can have parts added, or will send a player to a paired rocket if finished. Ends the game if Yugo is in the player's inventory.
 */
public class Rocket extends Character {


    private Actor rocket;
    private GameMap map;
    private boolean hasBody;
    private boolean hasEngine;

    /**
     * Construct a complete Rocket, pointing to a rocket and the map it's on. Sets the other rocket to point here.
     *
     * @param rocket the rocket to point to.
     * @param toMap    The map to point to.
     * @param thisMap    The map this rocket will be on.
     */
    public Rocket(Rocket rocket, GameMap toMap,GameMap thisMap) {

        super(new LoopingController(new StandStillBehaviour()), "ROCKET", DisplayCharacters.ROCKET, 6, 5);
        this.map = toMap;
        rocket.setRocket(this);
        rocket.setMap(thisMap);
        this.rocket = rocket;
        this.hasBody = true;
        this.hasEngine = true;
    }
    /**
     * Construct a Rocket, pointing to a rocket and the map it's on. Sets the other rocket to point here. Has parameters on rocket completeness.
     *
     * @param rocket the rocket to point to.
     * @param toMap    The map to point to.
     * @param thisMap    The map this rocket will be on.
     * @param hasEngine The status of the engine for this rocket
     * @param hasBody The status of the body for this rocket
     *
     */
    public Rocket(Rocket rocket, GameMap toMap, GameMap thisMap, boolean hasEngine, boolean hasBody) {

        super(new LoopingController(new StandStillBehaviour()), "ROCKET", DisplayCharacters.ROCKET, 6, 5);
        this.map = toMap;
        rocket.setRocket(this);
        rocket.setMap(thisMap);
        this.rocket = rocket;
        this.hasBody = hasBody;
        this.hasEngine = hasEngine;
    }

    /**
     * Construct a complete Rocket, if there is no other rocket to point to.
     *
     * @param toMap The map this rocket is in.
     */
    public Rocket(GameMap toMap) {
        super(new LoopingController(new StandStillBehaviour()), "ROCKET", DisplayCharacters.ROCKET, 6, 5);
        this.map = toMap;
        this.rocket = this;
        this.hasBody = true;
        this.hasEngine = true;
    }
    /**
     * Construct a Rocket, if there is no other rocket to point to. Has parameters on rocket completeness.
     *
     * @param map The map this rocket is in.
     */
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

    public void setRocket(Actor rocket) { this.rocket = rocket; }

    public void setMap(GameMap map) {
        this.map = map;
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
