package game.actions;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import game.characters.Character;
import game.status.StunStatus;

import java.util.Random;

/**
 * Stun another character
 */
public class StunAction extends Action {

    private Character subject;
    private Random rand = new Random();
    private int duration;

    /**
     * Construct a StunAction
     * @param subject Stun target
     */
    public StunAction(Character subject, int duration) {
        this.subject = subject;
        this.duration = duration;
    }

    /**
     * How the action is described on the menu
     * @param actor The actor performing the action.
     * @return String to describe the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " stuns " + subject;
    }

    /**
     * Attempt to apply the stun effect to the target character.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return Message about the progress of the action.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (rand.nextBoolean()) {
            subject.addStatusEffect(new StunStatus(duration));
            return actor + " stuns " + subject + ".";
        } else {
            return actor + " fails to stun " + subject + ".";
        }
    }

    /**
     * Hotkey for stun action.
     * @return Empty string since action does not have a hotkey
     */
    @Override
    public String hotKey() {
        return "";
    }
}
