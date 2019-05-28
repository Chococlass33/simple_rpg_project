package game.test_applications;

import edu.monash.fit2099.engine.*;
import game.Floor;
import game.Wall;
import game.characters.Player;
import game.characters.Rocket;
import game.ground.RocketPad;
import game.items.OxygenTank;
import game.items.Spacesuit;
import game.status.VacuumStatus;

import java.util.Arrays;
import java.util.List;

public class SpacesuitMap {

	public static void main(String[] args) {

		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(), new RocketPad());
		GameMap gameMap;

		List<String> map = Arrays.asList(
				"...",
				"...",
				"...");
		gameMap = new GameMap(groundFactory, map);
		world.addMap(gameMap);

		// Player
		Player player = new Player("Player");
		world.addPlayer(player, gameMap, 0, 0);

		// Rocket
		Actor rocket = new Rocket(gameMap);
		gameMap.addActor(rocket, 1, 1);

		player.addItemToInventory(new Spacesuit());
		player.addItemToInventory(new OxygenTank(2));
		player.addItemToInventory(new OxygenTank(0));
		player.addItemToInventory(new OxygenTank( 5));

		player.addStatusEffect(new VacuumStatus(9, gameMap, rocket));

		world.run();
	}
}
