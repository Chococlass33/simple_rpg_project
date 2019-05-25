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

    /**
     * Construct a Ninja.
     *
     * @param name   Ninja name.
     * @param target The target of the ninja.
     */

    private Character rocket;
    private GameMap map;

    public Rocket(Rocket rocket, GameMap map) {

        super(new LoopingController(new StandStillBehaviour()), "ROCKET", DisplayCharacters.ROCKET, 6, 5);
        this.map = map;
        int x = map.locationOf(target).x();
        int y = map.locationOf(target).y();
        map.removeActor(target);
        map.addActor(new Rocket(this, this.map), x, y);
        this.rocket = rocket;
    }

    public Rocket() {
        super(new LoopingController(new StandStillBehaviour()), "ROCKET", DisplayCharacters.ROCKET, 6, 5);
    }

    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        Actions tempActions = new Actions(new MoveMapAction(this.map,this.rocket));
        return tempActions;
        }
    }
}
