package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Player;
import edu.monash.fit2099.engine.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application{

	public static void main(String[] args) {

		System.setProperty("log4j.configuration","log4j2.xml");
		Logger logger = LogManager.getLogger(Application.class);
		logger.info("Starting game");
		World world = new World(new LogDisplay());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall());
		GameMap gameMap;

		List<String> map = Arrays.asList(
				".#.....................",
				"#.#.#####....######....",
				".#..#...#....#....#....",
				"....#........#....#....",
				"....#####....##.###....",
				".......................",
				".......................",
				".......................",
				".......................",
				".......................",
				".......................");
		gameMap = new GameMap(groundFactory, map);
		world.addMap(gameMap);
		Actor player = new Player("Player", '@', 1, 100);
		world.addPlayer(player, gameMap, 10, 1);
		Grunt grunt = new Grunt("Mongo", player);
		gameMap.addActor(grunt, 1, 1);
		Grunt grunt2 = new Grunt("Norbert", player);
		gameMap.addActor(grunt2,  10, 10);
		Ninja ninja = new Ninja("Billy", grunt); // TODO Ninja can only target characters not actors. to target the player we need player to be a subclass of character
		gameMap.addActor(ninja, 0, 0);
		world.run();
	}
}
