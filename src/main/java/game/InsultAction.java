package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

import java.util.Random;

/**
 * Insult a character
 */
public class InsultAction extends Action {


    private Random rand = new Random();
    private Actor insultTarget;

    // Insults sourced from https://funny-insults.com/stupid-insults/
    private static final String[] insults = {"Zombies eat brains... you're safe.",
            "You're the reason this country has to put directions on shampoo.",
            "Why is it acceptable for you to be an idiot, but not acceptable for me to point it out?",
            "I was hoping for a battle of wits, but you appear to be unarmed.",
            "Come back and talk to me when your I.Q. exceeds your age.",
            "Were you born this stupid or did you take lessons?",
            "If you spoke your mind, you'd be speechless.",
            "I'm sorry I hurt your feelings when I called you stupid. I really thought you already knew.",
            "If you think you're a wit, you're half right.",
            "As a failure, you are a great success.",
            "You are depriving some poor village of its idiot.",
            "Everyone has a right to be stupid. You are abusing the privilege",
            "You're so stupid, you went to the dentist to get bluetooth.",
            "You're so stupid you threw a rock at the ground and missed.",
            "You're so dumb that you got hit by a parked car.",
    };

    /**
     * Construct an insult action
     *
     * @param target Actor to insult
     */
    public InsultAction(Actor target) {
        insultTarget = target;
    }

    /**
     * Insult another actor.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return A description of the action's outcome.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return actor + " screams: " + "HEY " + insultTarget + ". " + insults[rand.nextInt(insults.length)];
    }

    /**
     * How the action is described in a menu.
     *
     * @param actor The actor performing the action.
     * @return String of action desciption.
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Insult " + insultTarget + ".";
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
