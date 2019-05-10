package game;

import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.World;
import game.Items.*;
import game.characters.*;
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
				".#.....................",
				"#.#.#####....######....",
				".#..#...#....#....#....",
				"....#...-....#....#....",
				"....#####....##+###....",
				".......................",
				".......................",
				".......................",
				"................@......",
				".......................",
				".......................");
		gameMap = new GameMap(groundFactory, map);
		world.addMap(gameMap);
		Player player = new Player("Player");
		world.addPlayer(player, gameMap, 10, 1);
		gameMap.addItem(new Key(), 10,2);
		gameMap.addItem(new Key(), 10,3);
		gameMap.addItem(new Warhammer(), 10,4);
		gameMap.addItem(new RocketBody(), 10,5);
		gameMap.addItem(new RocketEngine(), 10,6);
		gameMap.addItem(new RocketPlans(), 10,7);
		Grunt grunt = new Grunt("Mongo", player);
		gameMap.addActor(grunt, 1, 1);
		Grunt grunt2 = new Grunt("Norbert", player);
		gameMap.addActor(grunt2,  10, 10);
		Ninja ninja = new Ninja("Billy", player); // TODO Ninja can only target characters not actors. to target the player we need player to be a subclass of character
		gameMap.addActor(ninja, 0, 0);
		Goon goon = new Goon("Valerie", player);
		gameMap.addActor(goon, 9, 10);
		DoctorMaybe doctor = new DoctorMaybe("Doctor Maybe");
		gameMap.addActor(doctor, 2, 10);
		Q q = new Q();
		gameMap.addActor(q, 3, 10);

		world.run();
	}
}
