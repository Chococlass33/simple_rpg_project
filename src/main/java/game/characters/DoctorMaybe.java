package game.characters;

import game.DisplayCharacters;
import game.Items.RocketEngine;
import game.behaviours.StandStillBehaviour;
import game.controllers.LoopingController;

/**
 * Doctor maybe miniboss. Drop rocket plans on death.
 */
public class DoctorMaybe extends Character {

    /**
     * Construct a Doctor Maybe mini boss.
     */
    public DoctorMaybe(String name) {
        // Create suitable character
        super(new LoopingController(new StandStillBehaviour()), name, DisplayCharacters.DOCTOR_MAYBE, 7, 25, 2);
        // Give rocket plans
        this.addToInventory(new RocketEngine());
    }

}
