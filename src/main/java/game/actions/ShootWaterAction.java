package game.actions;

import edu.monash.fit2099.engine.*;
import game.items.ExoSkeleton;
import game.items.WaterGun;

import java.util.List;
import java.util.Random;

import static game.DisplayCharacters.XSURROUND;
import static game.DisplayCharacters.YSURROUND;

/**
 * Special Action for attacking other Actors.
 */
public class ShootWaterAction extends Action {

	private WaterGun gun;
	private Random random;

	public ShootWaterAction(WaterGun gun) {
		this.gun = gun;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		String tempstring = actor +" attempts to use the water gun.\n";
		if(gun.getFilled())
		{
			int x = map.locationOf(actor).x();
			int y = map.locationOf(actor).y();
			gun.unfill();
			for(int i = 0; i < 8; i++){
				try
				{
					if(map.isAnActorAt(map.at(x+XSURROUND[i],y+YSURROUND[i]))){
						Actor tempactor = map.actorAt(map.at(x+XSURROUND[i],y+YSURROUND[i]));

						tempstring += tempactor + " gets sprayed by water!\n";
						List<Item> inventory = tempactor.getInventory();

						for (Item item : inventory) {
							if (item instanceof ExoSkeleton) {
								// if key of correct colour is found
								tempstring += "The exoskeleton gets fried!\n";
								if(random.nextInt() % 10 < 7)
								{
									tempactor.removeItemFromInventory(item);
									tempstring += "The exoskeleton explodes in a puff of smoke!\n";
								}
								else
								{
									tempstring += "The exoskeleton survives, better try again\n";
								}

							}
						}
					}
				}
				finally
				{
				}
			}
			tempstring += "The water gun is all out of water now.";
		}
		else
		{
			tempstring += "The water gun is empty and cannot be used right now.";
		}
		return tempstring;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " sprays water all around a short distance.";
	}

	@Override
	public String hotKey() {
		return "";
	}
}
