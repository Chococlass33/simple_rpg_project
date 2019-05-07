package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * The looping controller changes the default NPC behaviour to iterate through possible actions and perform the first valid action it can.
 */
public class LoopingController implements Controller {

    private Logger logger = LogManager.getLogger(this.getClass());

    // List of possible actions that can be made
    private List<ActionFactory> actionFactories = new ArrayList<>();

    /**
     * Create a looping controller with a list of acceptable behaviours
     * @param behaviours Acceptable behaviours
     */
    LoopingController(ActionFactory... behaviours) {
        actionFactories.addAll(Arrays.asList(behaviours));
    }

    /**
     * Iterate through possible actions and return the first valid action
     * @param subject The character to perform the action
     * @param actions collection of possible Actions for this Actor
     * @param map the map containing the Actor
     * @param display the I/O object to which messages may be written
     * @return Action to be performed.
     */
    public Optional<Action> selectedAction(Character subject, Actions actions, GameMap map, Display display) {
        for (ActionFactory factory : actionFactories) {
            Action action = factory.getAction(subject, map);
            if(action != null) {
                logger.debug("Character: {} selected action: {}", subject.getName(), action.getClass().getSimpleName());
                return Optional.of(action);
            }
        }

        logger.debug("Character: {}, selected no action", subject.getName());
        return Optional.empty();
    }

    /**
     * Add a possible action to the looping controller
     * @param behaviour ActionFactory implementation to add
     */
    protected void addBehaviour(ActionFactory behaviour) {
        actionFactories.add(behaviour);
    }
}
