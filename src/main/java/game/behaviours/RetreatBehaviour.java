package game.behaviours;

import edu.monash.fit2099.engine.*;

/**
 * Retreat further from the target if the target gets to close.
 */
public class RetreatBehaviour implements ActionFactory {

    private Actor target;
    private int minAcceptableDistance;

    /**
     * Construct a retreat behaviour
     *
     * @param target                The target to retreat fom
     * @param minAcceptableDistance The minimum distance to try and maintain. If the target comes closer than the acceptable distance attempt to increase the distance.
     */
    public RetreatBehaviour(Actor target, int minAcceptableDistance) {
        this.target = target;
        this.minAcceptableDistance = minAcceptableDistance;
    }

    /**
     * If the target is too close, retreat.
     *
     * @param actor actor with the behaviour.
     * @param map   game map containing the actor.
     * @return Either null or a Retreat action.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {

        Location here = map.locationOf(actor);
        Location there = map.locationOf(target);

        int currentDistance = distance(here, there);
        if (currentDistance <= minAcceptableDistance) {
            for (Exit exit : here.getExits()) {
                Location destination = exit.getDestination();
                if (destination.canActorEnter(actor)) {
                    int newDistance = distance(destination, there);
                    if (newDistance > currentDistance) {
                        return new MoveActorAction(destination, exit.getName());
                    }
                }
            }
        }

        return null;
    }

    /**
     * ge the distance between two points
     *
     * @param a point 1
     * @param b point 2
     * @return distance between points
     */
    private int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }
}
