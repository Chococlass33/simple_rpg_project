package game;

import edu.monash.fit2099.engine.*;


public class Grunt extends LoopingController {

	// Grunts have 50 hit points and are always represented with a g
	public Grunt(String name, Actor player) {
		super(name, 'g', 5, 50);
		addBehaviour(new FollowBehaviour(player));
	}

}
