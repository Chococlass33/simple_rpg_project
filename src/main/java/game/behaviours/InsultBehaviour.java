package game.behaviours;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import game.actions.InsultAction;

import java.util.Random;

/**
 * Produce an InsultAction if the right conditions are met.
 */
public class InsultBehaviour implements ActionFactory {

    private Random rand = new Random();
    private Actor target;

    /**
     * Insult another actor
     * @param target Actor to insult
     */
    public InsultBehaviour(Actor target) {
        this.target = target;
    }


    /**
     * Insult another actor or return null
     * @param actor Actor making the insult
     * @param map The game map containing the actors
     * @return either an insult action or null
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {

        if (rand.nextInt(9) < 1) {
            // 10% chance of insult
            return new InsultAction(target);
        }
        return null;
    }
}
