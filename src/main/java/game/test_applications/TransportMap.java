package game.test_applications;

import edu.monash.fit2099.engine.*;
import game.Floor;
import game.Wall;
import game.characters.Player;
import game.characters.Rocket;
import game.ground.RocketPad;

import java.util.Arrays;
import java.util.List;

public class TransportMap {

	public static void main(String[] args) {

		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(), new RocketPad());
		GameMap primaryMap;
		GameMap secondaryMap;

		List<String> map = Arrays.asList(
				"...",
				"...",
				"...");
		List<String> secondaryMapLayout = Arrays.asList(
				"###",
				"...",
				"###"
		);
		primaryMap = new GameMap(groundFactory, map);
		secondaryMap = new GameMap(groundFactory, secondaryMapLayout);
		world.addMap(primaryMap);
		world.addMap(secondaryMap);

		// Player
		Player player = new Player("Player");
		world.addPlayer(player, primaryMap, 0, 0);

		// Rockets
		Actor primaryRocket = new Rocket(secondaryMap);
		primaryMap.addActor(primaryRocket,1, 1);
		Actor secondaryRocket = new Rocket(primaryMap);
		secondaryMap.addActor(secondaryRocket, 1, 1);

		world.run();
	}
}
