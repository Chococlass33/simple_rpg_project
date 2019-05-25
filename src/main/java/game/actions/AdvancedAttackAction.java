package game.actions;

import edu.monash.fit2099.engine.*;
import game.characters.Character;

import java.util.Random;

/**
 * Special Action for attacking other Actors. Improves the original attack action by correctly reporting the damage taken.
 */
public class AdvancedAttackAction extends Action {

	private Actor actor;
	private Character subject;
	private Random rand = new Random();

	public AdvancedAttackAction(Actor actor, Character subject) {
		this.actor = actor;
		this.subject = subject;
	}

	@Override
	public String execute(Actor actor, GameMap map) {

		Weapon weapon = actor.getWeapon();

		if (rand.nextBoolean()) {
			return actor + " misses " + subject + ".";
		}

		int damage = weapon.damage();
		int originalHealth = subject.getHealth();
		subject.hurt(damage);
		damage = originalHealth - subject.getHealth();
		// Report actual damage
		String result = actor + " " + weapon.verb() + " " + subject + " for " + damage + " damage.";

		// Handle defence
		if (subject.getDefence() > 0) {
			result += " Damage is reduced by " + subject.getDefence() + " due to " + subject.getName() + "'s armour.";
		}

		if (!subject.isConscious()) {
			//Drop all the items that are droppable. 
			Item sleepingActor = new Item("Sleeping " + subject, '%');
			map.locationOf(subject).addItem(sleepingActor);
			for (Item item : subject.getInventory()) {
				for (Action action : item.getAllowableActions()) {
					if (action instanceof DropItemAction) {
						action.execute(subject, map);
						break;
					}
				}
			}
			map.removeActor(subject);
			result += System.lineSeparator() + subject + " is knocked out.";
		}

		return result;

	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " attacks " + subject;
	}

	@Override
	public String hotKey() {
		return "";
	}
}
