package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class EmptyController implements Controller {

    private Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Return no action.
     *
     * @param subject The character to perform the action
     * @param actions collection of possible Actions for this Actor
     * @param map     the map containing the Actor
     * @param display the I/O object to which messages may be written
     * @return Action to be performed.
     */
    public Optional<Action> selectedAction(Character subject, Actions actions, GameMap map, Display display) {
        logger.debug("Character: {}, selected no action", subject.getName());
        return Optional.empty();
    }
}
