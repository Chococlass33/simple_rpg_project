package game.behaviours;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import game.characters.Character;
import game.status.StunStatus;
import game.actions.StunAction;

/**
 * Return a stun action.
 */
public class StunBehaviour implements ActionFactory {

    private Character target;
    private int range;
    private int stunDuration;

    /**
     * Construct a Stun Behaviour object.
     * @param target The target to attempt to stun.
     * @param range The maximum striking distance
     */
    public StunBehaviour(Character target, int range, int stunDuration) {
        this.target = target;
        this.range = range;
        this.stunDuration = stunDuration;
    }

    /**
     * Return a stun action if the target is within striking distance.
     * @param actor actor with the behaviour.
     * @param map game map containing the actor.
     * @return Either null or a StunAction.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {

        Location here = map.locationOf(actor);
        Location there = map.locationOf(target);

        int distance = distance(here, there);
        if (distance <= range && !target.getStatusEffects().contains(StunStatus.STUN_STATUS)) {
            // If target is in range and not already stunned
            return new StunAction(target, stunDuration);
        }

        return null;
    }

    /**
     * ge the distance between two points
     * @param a point 1
     * @param b point 2
     * @return distance between points
     */
    private int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }
}
