package game;

import edu.monash.fit2099.engine.*;
import game.Items.*;
import game.characters.*;
import game.characters.Player;
import game.ground.LockedDoor;
import game.ground.RocketPad;
import game.ground.UnlockedDoor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class Application{

	public static void main(String[] args) {

		System.setProperty("log4j.configuration","log4j2.xml");
		Logger logger = LogManager.getLogger(Application.class);
		logger.info("Starting game");
		World world = new World(new LogDisplay());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(), new LockedDoor(), new UnlockedDoor(), new RocketPad());
		GameMap gameMap;

		List<String> map = Arrays.asList(
				"................#......",
				"....#####....######.#.#",
				"....#.#.#....#....#####",
				"....#........#....#.#.#",
				"....###########.###....",
				".......................",
				".......................",
				".......................",
				".......................",
				"...........?...........",
				".......................");
		gameMap = new GameMap(groundFactory, map);
		world.addMap(gameMap);

		// Player
		Player player = new Player("Player");
		world.addPlayer(player, gameMap, 10, 0);

		// Misc Items
		gameMap.addItem(new Warhammer(), 0,0);

		// Enemies
		Grunt grunt = new Grunt("Mongo", player);
		gameMap.addActor(grunt, 1, 1);

		Grunt grunt2 = new Grunt("Norbert", player);
		gameMap.addActor(grunt2,  10, 10);

		Ninja ninja = new Ninja("Billy", player);
		gameMap.addActor(ninja, 5, 2);

		Goon goon = new Goon("Valerie", player);
		gameMap.addActor(goon, 9, 10);

		DoctorMaybe doctor = new DoctorMaybe("Doctor Maybe");
		gameMap.addActor(doctor, 5, 5);

		// Keys
		ninja.addItemToInventory(new Key(DisplayCharacters.COLORS[0]));
		goon.addItemToInventory(new Key(DisplayCharacters.COLORS[1]));

		// Doors
		Ground door1 = new UnlockedDoor(DisplayCharacters.COLORS[1]);
		Ground door2 = new LockedDoor(DisplayCharacters.COLORS[0]);
		gameMap.add(door1, gameMap.at(8, 3));
		gameMap.add(door2, gameMap.at(15, 4));

		// Rocket Parts
		gameMap.addItem(new RocketBody(), 10,5);
		gameMap.addItem(new RocketPlans(), 14,2);

		// Allies
		Q q = new Q();
		gameMap.addActor(q, 3, 10);

		world.run();
	}
}
