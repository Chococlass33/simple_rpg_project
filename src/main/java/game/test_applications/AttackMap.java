package game.test_applications;

import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.World;
import game.Floor;
import game.Wall;
import game.characters.Character;
import game.characters.Player;
import game.characters.YugoMaxx;
import game.ground.RocketPad;
import game.ground.Water;
import game.items.WaterGun;

import java.util.Arrays;
import java.util.List;

public class AttackMap {

	public static void main(String[] args) {

		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(), new RocketPad(), new Water());
		GameMap gameMap;

		List<String> map = Arrays.asList(
				".~.",
				"...",
				"...");
		gameMap = new GameMap(groundFactory, map);
		world.addMap(gameMap);

		// Player
		Player player = new Player("Player");
		world.addPlayer(player, gameMap, 0, 0);
		player.addItemToInventory(new WaterGun());

		Character yugo = new YugoMaxx();
		gameMap.addActor(yugo, 0, 1);
		world.run();
	}
}
