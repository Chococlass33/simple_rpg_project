package game;

import edu.monash.fit2099.engine.*;
import game.items.*;
import game.characters.*;
import game.characters.Player;
import game.ground.LockedDoor;
import game.ground.RocketPad;
import game.ground.UnlockedDoor;

import java.util.Arrays;
import java.util.List;

public class Application{

	public static void main(String[] args) {

		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(), new RocketPad());
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

		// Misc items
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

		OxygenDispenser dispenser = new OxygenDispenser();
		gameMap.addActor(dispenser, 10, 6);

		// Keys
		ninja.addItemToInventory(new Key(DisplayCharacters.colour.BLUE));
		goon.addItemToInventory(new Key(DisplayCharacters.colour.GREEN));

		// Doors
		Ground door1 = new UnlockedDoor(DisplayCharacters.colour.GREEN);
		Ground door2 = new LockedDoor(DisplayCharacters.colour.BLUE);
		gameMap.add(door1, gameMap.at(8, 3));
		gameMap.add(door2, gameMap.at(15, 4));

		// Rocket Parts
		gameMap.addItem(new RocketPlans(), 14,2);

		// Allies
		Q q = new Q();
		gameMap.addActor(q, 3, 10);

		world.run();
	}
}
