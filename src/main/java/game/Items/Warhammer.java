package game.Items;

import edu.monash.fit2099.engine.WeaponItem;
import game.DisplayCharacters;
/**
 * A Weapon. Used to increase damage.
 */
public class Warhammer extends WeaponItem {
    /**
     * Create a warhammer object.
     */
    public Warhammer() {
        super("War-Hammer", DisplayCharacters.WARHAMMER,50,"threatens");
    }
}
