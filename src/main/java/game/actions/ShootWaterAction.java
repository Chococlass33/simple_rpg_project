package game.actions;

import edu.monash.fit2099.engine.*;
import game.items.ExoSkeleton;
import game.items.WaterGun;

import java.util.List;
import java.util.Random;

import static game.DisplayCharacters.XSURROUND;
import static game.DisplayCharacters.YSURROUND;

/**
 * Special Action for shooting water around the actor.
 */
public class ShootWaterAction extends Action {

    private WaterGun gun;
    private Random random = new Random();

    /**
     * Constructor, takes the water gun as a parameter.
     * @param gun the gun item used
     */
    public ShootWaterAction(WaterGun gun) {
        this.gun = gun;
    }

    /**
     * Executes the action. Checks all actors around actor for an exoskeleton and tries to destroy it if filled with water.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return action text
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String tempstring = actor + " attempts to use the water gun.\n";
        if (gun.getFilled()) {
            int x = map.locationOf(actor).x();
            int y = map.locationOf(actor).y();
            gun.unfill();
            for (int i = 0; i < 8; i++) {
                try {
                    if (map.isAnActorAt(map.at(x + XSURROUND[i], y + YSURROUND[i]))) {
                        Actor tempactor = map.actorAt(map.at(x + XSURROUND[i], y + YSURROUND[i]));

                        tempstring += tempactor + " gets sprayed by water!\n";
                        List<Item> inventory = tempactor.getInventory();

                        for (Item item : inventory) {
                            if (item instanceof ExoSkeleton) {
                                // If inventory contains an exoskeleton
                                tempstring += "Water covers the exoskeleton!\n";
                                if (random.nextInt() % 10 < 7) {
                                        tempactor.removeItemFromInventory(item);
                                    tempstring += "The exoskeleton explodes in a puff of smoke!\n";
                                } else {
                                    tempstring += "The exoskeleton survives, better try again\n";
                                }

                            }
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {
                    // Triggered when an invalid index is accessed
                    // System.out.println(ex.getMessage());
                }
            }
            tempstring += "The water gun is all out of water now.";
        } else {
            tempstring += "The water gun is empty and cannot be used right now.";
        }
        return tempstring;
    }
    /**
     * How the action is described on the menu
     * @param actor The actor performing the action.
     * @return String to describe the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " sprays water all around a short distance.";
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
