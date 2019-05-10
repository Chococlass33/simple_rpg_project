package game.characters;

import game.DisplayCharacters;
import game.controllers.PlayerController;
/**
 * A Player. Will be controlled by the user.
 */
public class Player extends Character {
    /**
     * Construct a Player.
     *
     * @param name   Player name.
     */
    public Player(String name) {
        super(new PlayerController(), name, DisplayCharacters.PLAYER, 1, 100, 5);
    }
}
