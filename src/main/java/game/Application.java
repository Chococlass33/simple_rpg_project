package game;

import edu.monash.fit2099.engine.*;
import game.ground.Water;
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

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(), new RocketPad(), new Water());
		GameMap gameMap;
		GameMap moonMap;

		List<String> map = Arrays.asList(
				"................#......",
				"....#####....######.#.#",
				"....#.#.#....#....#####",
				"....#........#....#.#.#",
				"....###########.###....",
				".......................",
				".......................",
				"............~...........",
				".......................",
				".......................",
				".......................");
		List<String> moonLayout = Arrays.asList(
				"....#..................",
				"....#..................",
				".####......#...........",
				"..........###..........",
				".........#####.........",
				"..........###..........",
				"...........#...........",
				"............~...........",
				".......................",
				".......................",
				".......................");
		gameMap = new GameMap(groundFactory, map);
		moonMap = new GameMap(groundFactory, moonLayout);
		world.addMap(gameMap);
		world.addMap(moonMap);

		// Player
		Player player = new Player("Player");
		world.addPlayer(player, gameMap, 10, 0);

		// Misc items
		gameMap.addItem(new Warhammer(), 1,1);
		moonMap.addItem(new WaterGun(), 3, 1);

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

		YugoMaxx boss = new YugoMaxx();
		moonMap.addActor(boss, 10, 10);

		Grunt grunt3 = new Grunt("Fain", player);
		moonMap.addActor(grunt3, 5,5);

		Ninja ninja2 = new Ninja("Jack", player);
		moonMap.addActor(ninja2, 0,8);

		Goon goon2 = new Goon("Max", player);
		moonMap.addActor(goon2 ,8, 0);

		Rocket rocket1 = new Rocket(gameMap, false, false);
		gameMap.addActor(rocket1, 12, 9);

		Rocket rocket2 = new Rocket(rocket1, gameMap, moonMap);
		moonMap.addActor(rocket2, 0, 0);

		// Keys
		ninja.addItemToInventory(new Key(DisplayCharacters.colour.BLUE));
		goon.addItemToInventory(new Key(DisplayCharacters.colour.GREEN));
		grunt.addItemToInventory(new Key(DisplayCharacters.colour.RED));

		// Doors
		Ground door1 = new UnlockedDoor(DisplayCharacters.colour.GREEN);
		Ground door2 = new LockedDoor(DisplayCharacters.colour.BLUE);
		Ground door3 = new LockedDoor(DisplayCharacters.colour.RED);
		gameMap.add(door1, gameMap.at(8, 3));
		gameMap.add(door2, gameMap.at(15, 4));
		moonMap.add(door3, moonMap.at(0, 2));

		// Rocket Parts
		gameMap.addItem(new RocketPlans(), 14,2);

		// Allies
		Q q = new Q();
		gameMap.addActor(q, 3, 10);

		world.run();
		if(!player.isConscious())
		{
			System.out.println("Bad End. RIP " + player);
		}
	}
}
