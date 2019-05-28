package game.status;

import edu.monash.fit2099.engine.*;
import game.actions.MoveMapAction;
import game.behaviours.StandStillBehaviour;
import game.characters.Character;
import game.items.OxygenTank;
import game.items.Spacesuit;

import java.util.List;
import java.util.Optional;

/**
 * A status effect for characters within a vacuum
 */
public class VacuumStatus extends StatusEffect {

    public static final String VACUUM_STATUS = "Vacuum Status";
    private GameMap map;
    private Actor rocket;
    /**
     * Create a vacuum status
     * @param duration How long the status will last
     */
    public VacuumStatus(int duration, GameMap map, Actor rocket) {
        super(duration, VACUUM_STATUS);
        this.rocket = rocket;
        this.map = map;
    }

    /**
     * Check if the character can take a breath. Teleport them if they cannot.
     * @param subject The character to apply the effect to
     * @return Possibly an action to teleport them home.
     */
    @Override
    protected Optional<Action> executeEffect(Character subject, Display display) {

        // Check for a space suit
        Optional<Spacesuit> spacesuit = getSpaceSuit(subject);
        if (!spacesuit.isPresent()) {
            // Character doe snot have a space suit
            display.println(subject.getName() + " can breathe without a space suit! They begin to suffocate!");
            return takeBreath(subject);

        } else {
            // Character does have a spacesuit

            Optional<Action> returnAction = takeBreath(subject);

            if (returnAction.isPresent()) {
                // If the character can't breath attempt to attach any oxygen tanks currently in their inventory to the spacesuit
                Optional<OxygenTank> newTank = getOxygenTank(subject);
                while (newTank.isPresent()) {
                    // While the character has oxygen tanks in their inventory
                    if (newTank.get().getOxygenStored() < 1) {
                        // Remove empty tanks from inventory
                        display.println(subject.getName() + " fumbles for a filled oxygen tank.");
                        subject.removeItemFromInventory(newTank.get());
                        newTank = getOxygenTank(subject);
                    } else {
                        // Attach an oxygen tank to the spacesuit
                        display.println(subject.getName() + " attaches a fresh oxygen tank to their spacesuit.");
                        spacesuit.get().attachOxygenTank(newTank.get());
                        subject.removeItemFromInventory(newTank.get());
                        returnAction = takeBreath(subject);
                        newTank = Optional.empty();
                    }
                }
            }

            if (!returnAction.isPresent()) {
                display.println(subject.getName() + " takes a deep breath of oxygen. " + spacesuit.get().remainingOxygen() + " breaths of oxygen remain.");
                return Optional.empty();

            } else {
                display.println(subject.getName() + "'s spacesuit has run out of oxygen. They begin to suffocate!");
                return returnAction;
            }
        }
    }

    /**
     * The character attempts to take a breath.
     * @param subject The character trying to breathe.
     * @return An optional action. The action is returned if the character cannot breathe.
     */
    private Optional<Action> takeBreath(Character subject) {

        Optional<Spacesuit> suit = getSpaceSuit(subject);
        if (!suit.isPresent() || !suit.get().breath()) {
            return Optional.of(new MoveMapAction(map,rocket)); //TODO Replace with teleport action
        }
        return Optional.empty();
    }


    /**
     * Check is the character has a spacesuit
     * @param subject The character's inventory to check
     * @return True if they have a space suit, false if they do not
     */
    private Optional<Spacesuit> getSpaceSuit(Character subject) {
        List<Item> inventory = subject.getInventory();

        for (Item item : inventory) {
            if (item instanceof Spacesuit) {
                return Optional.of((Spacesuit) item);
            }
        }
        return Optional.empty();
    }

    /**
     * Get an oxygen tank from the character's inventory.
     * @param subject The character;s inventory to check.
     * @return An optional oxygen tank.
     */
    private Optional<OxygenTank> getOxygenTank(Character subject) {
        List<Item> inventory = subject.getInventory();

        for (Item item : inventory) {
            if (item instanceof OxygenTank) {
                return Optional.of((OxygenTank) item);
            }
        }
        return Optional.empty();
    }


}
