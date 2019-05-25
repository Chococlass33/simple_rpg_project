package game.test_applications;

import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.World;
import game.Floor;
import game.Wall;
import game.characters.Player;
import game.ground.RocketPad;
import game.status.VacuumStatus;

import java.util.Arrays;
import java.util.List;

public class VacuumMap {

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

		player.addStatusEffect(new VacuumStatus(5));

		world.run();
	}
}
