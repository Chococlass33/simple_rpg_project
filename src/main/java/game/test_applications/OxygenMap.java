package game.test_applications;

import edu.monash.fit2099.engine.*;
import game.Floor;
import game.Wall;
import game.characters.Player;
import game.characters.*;
import game.ground.RocketPad;

import java.util.Arrays;
import java.util.List;

public class OxygenMap {

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

		OxygenDispenser dispenser = new OxygenDispenser();
		gameMap.addActor(dispenser, 1, 1);

		world.run();
	}
}
