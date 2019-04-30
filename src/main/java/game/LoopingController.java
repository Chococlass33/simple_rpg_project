package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;

import java.util.ArrayList;
import java.util.List;

/**
 * The looping controller changes the default NPC behaviour to iterate through possible actions and perform the first valid action it can.
 */
public class LoopingController extends Character {

    // List of possible actions that can be made
    private List<ActionFactory> actionFactories = new ArrayList<>();

    /**
     * Build a character controlled by a looping action
     * @param name Character name
     * @param displayChar The character used to display the character
     * @param priority The priority to execute
     * @param hitPoints The number of hit points
     */
    public LoopingController(String name, char displayChar, int priority, int hitPoints) {
        super(name, displayChar, priority, hitPoints);
    }

    /**
     * Build a character controlled by a looping action
     * @param name Character name
     * @param displayChar The character used to display the character
     * @param priority The priority to execute
     * @param hitPoints The number of hit points
     * @param intDamage The intrinsic damage of the character
     */
    public LoopingController(String name, char displayChar, int priority, int hitPoints, int intDamage) {
        super(name, displayChar, priority, hitPoints, intDamage);
    }

    /**
     * Iterate through possible actions and return the first valid action
     * @param actions collection of possible Actions for this Actor
     * @param map the map containing the Actor
     * @param display the I/O object to which messages may be written
     * @return Action to be performed
     */
    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        for (ActionFactory factory : actionFactories) {
            Action action = factory.getAction(this, map);
            if(action != null)
                return action;
        }

        return super.playTurn(actions,  map,  display);
    }

    /**
     * Add a possible action to the looping controller
     * @param behaviour ActionFactory implementation to add
     */
    protected void addBehaviour(ActionFactory behaviour) {
        actionFactories.add(behaviour);
    }
}
