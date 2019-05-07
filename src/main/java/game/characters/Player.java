package game.characters;

import game.DisplayCharacters;
import game.controllers.Controller;
import game.controllers.PlayerController;

public class Player extends Character {
    public Player(String name) {
        super(new PlayerController(), name, DisplayCharacters.PLAYER, 100, 100, 5);
    }
}
