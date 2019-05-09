package game.controllers;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import game.characters.Character;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

/**
 * The Player controller allows the player to make actions from the menu, selected from currently available actions.
 */
public class PlayerController implements Controller {
    private Logger logger = LogManager.getLogger(this.getClass());


    /**
     * Iterate through possible actions and return the action selected by the player
     * @param subject The character to perform the action, usually the player
     * @param actions collection of possible Actions for this Actor
     * @param map the map containing the Actor
     * @param display the I/O object to which messages may be written
     * @return Action to be performed.
     */
    @Override
    public Optional<Action> selectedAction(Character subject, Actions actions, GameMap map, Display display) {
        ArrayList<java.lang.Character> freeChars = new ArrayList<java.lang.Character>();
        HashMap<java.lang.Character, Action> keyToActionMap = new HashMap<java.lang.Character, Action>();

        for (char i = 'a'; i <= 'z'; i++)
            freeChars.add(i);

        for (Action action : actions) {
            String hotKey = action.hotKey();
            if (hotKey != "") {
                if (freeChars.isEmpty())
                    break;
                char c = hotKey.charAt(0);
                freeChars.remove(java.lang.Character.valueOf(c));
                keyToActionMap.put(c, action);
                display.println(hotKey + ": " + action.menuDescription(subject));
            }
        }

        for (Action action : actions) {
            if (action.hotKey() == "") {
                if (freeChars.isEmpty())
                    break;
                char c = freeChars.get(0);
                freeChars.remove(0);
                keyToActionMap.put(c, action);
                display.println(c + ": " + action.menuDescription(subject));
            }
        }

        char key;
        do {
            key = display.readChar();
        } while (!keyToActionMap.containsKey(key));

        return Optional.of(keyToActionMap.get(key));
    }
}

