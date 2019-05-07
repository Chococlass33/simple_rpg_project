package game.characters;

import edu.monash.fit2099.engine.*;
import game.DisplayCharacters;
import game.behaviours.FollowBehaviour;
import game.controllers.LoopingController;

public class Grunt extends Character {

	/**
	 * Create a grunt and set them to follow the behaviour with the looping controller.
	 * @param name Grunt name
	 * @param player Player character
	 */
	public Grunt(String name, Actor player) {
		super(new LoopingController(new FollowBehaviour(player)), name, DisplayCharacters.GRUNT, 5, 50);
	}

}
