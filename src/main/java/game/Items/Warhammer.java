package game.Items;

import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Weapon;
import edu.monash.fit2099.engine.WeaponItem;
import game.DisplayCharacters;

public class Warhammer extends WeaponItem {
    public Warhammer() {
        super("War-Hammer", DisplayCharacters.WARHAMMER,50,"threatens");
    }
}
