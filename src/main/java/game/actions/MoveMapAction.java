package game.actions;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import game.characters.Character;
import game.status.VacuumStatus;

/**
 * The actor inspects the rocket
 */
public class MoveMapAction extends Action {
    private GameMap map;
    private Actor rocket;

    /**
     * Construct a CheckPad action
     *
     * @param map Location of the rocket pad.
     * @param hasBody Boolean representing the status of the rocket body.
     * @param hasEngine Boolean representing the status of the rocket engine.
     */
    public MoveMapAction(GameMap map, Actor rocket) {

        this.map = map;
        this.rocket = rocket;
    }
    /**
     * An actor checks the rocket pad.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return A description of the action's outcome.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        this.map.addActor(actor,map.locationOf(rocket).x() + 1,map.locationOf(rocket).y() + 1);
        Character character = (Character) actor;
        if(character.hasStatusEffect("VacuumStatus"))
        {
            character.removeStatusEffect("VacuumStatus");
        }
        else
        {
            character.addStatusEffect(new VacuumStatus(10, this.map, rocket));
        }
        return actor + " gets sent to a whole new world!";
    }
    /**
     * How the action is described in a menu.
     *
     * @param actor The actor performing the action.
     * @return String of action desciption.
     */


    @Override
    public String menuDescription(Actor actor) {
        return actor + " moves to another map.";
    }

    /**
     * Action hotkey.
     *
     * @return Return empty string. No dedicated hot key.
     */
    @Override
    public String hotKey() {
        return "";
    }
}
