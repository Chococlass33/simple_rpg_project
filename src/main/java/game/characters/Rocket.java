package game.characters;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import game.DisplayCharacters;
import game.actions.GivePlansAction;
import game.actions.MoveMapAction;
import game.actions.TalkAction;
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
    /**
     * Construct a Rocket, pointing to a rocket and the map it's on.
     *
     * @param rocket   the rocket to point to.
     * @param map The map to point to.
     */
    public Rocket(Actor rocket, GameMap map) {

        super(new LoopingController(new StandStillBehaviour()), "ROCKET", DisplayCharacters.ROCKET, 6, 5);
        this.map = map;
        int x = map.locationOf(rocket).x();
        int y = map.locationOf(rocket).y();
        map.removeActor(rocket);
        Actor newRocket = new Rocket(this, this.map);
        map.addActor(newRocket,x,y);
        this.rocket = newRocket;
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
    }

    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        return new Actions(new MoveMapAction(this.map, this.rocket));
        }
    }
