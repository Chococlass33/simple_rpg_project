package game.behaviours;

import edu.monash.fit2099.engine.*;

/**
 * Follow a certain actor
 */
public class FollowBehaviour implements ActionFactory {

	private Actor target;

	/**
	 * Construct a follow behaviour
	 * @param subject Target to follow
	 */
	public FollowBehaviour(Actor subject) {
		this.target = subject;
	}

	/**
	 * Follow the target actor
	 * @param actor Actor to follow
	 * @param map Map containing the actors
	 * @return Null or a move action
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		Location here = map.locationOf(actor);
		Location there = map.locationOf(target);
		if (there == null)
		{
			return null;
		}

		int currentDistance = distance(here, there);
		for (Exit exit : here.getExits()) {
			Location destination = exit.getDestination();
			if (destination.canActorEnter(actor)) {
				int newDistance = distance(destination, there);
				if (newDistance < currentDistance) {
					return new MoveActorAction(destination, exit.getName());
				}
			}
		}

		return null;
	}

	/**
	 * Caculate distance between point A and B
	 * @param a First point
	 * @param b Second point
	 * @return Distance
	 */
	private int distance(Location a, Location b) {
		return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
	}
}