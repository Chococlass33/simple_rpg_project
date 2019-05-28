package game.actions;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import game.characters.Character;
import game.status.VacuumStatus;

import java.util.List;

import static game.DisplayCharacters.XSURROUND;
import static game.DisplayCharacters.YSURROUND;

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
        for (int i = 0; i < 8; i++) {
            try {
                if (!map.isAnActorAt(map.at(map.locationOf(rocket).x() + XSURROUND[i], map.locationOf(rocket).y() + YSURROUND[i])) & map.at(map.locationOf(rocket).x() + XSURROUND[i], map.locationOf(rocket).y() + YSURROUND[i]).canActorEnter(actor)) {
                    map.removeActor(actor);
                    List<Item> inventory = actor.getInventory();
                    for (Item item : inventory) {
                        if (item.toString().contains("Yugo Maxx")) {
                            return actor + " turns Yugo Maxx into the police! Victory!";
                        }
                    }
                    this.map.addActor(actor, map.locationOf(rocket).x() + XSURROUND[i], map.locationOf(rocket).y() + YSURROUND[i]);
                    Character character = (Character) actor;
                    if (character.hasStatusEffect(VacuumStatus.VACUUM_STATUS)) {
                        character.removeStatusEffect(VacuumStatus.VACUUM_STATUS);
                    } else {
                        character.addStatusEffect(new VacuumStatus(10, map, rocket));
                    }
                    return actor + " gets sent to a whole new world!";
                }
            } catch (IndexOutOfBoundsException ex) {
                // For when the index does not exist within the maps confines
            }
        }
        return "You would've totally travelled back but the landing point is completely surrounded somehow.";
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
