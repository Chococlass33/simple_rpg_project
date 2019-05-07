package game.characters;

import edu.monash.fit2099.engine.*;
import game.DisplayCharacters;
import game.actions.GivePlansAction;
import game.behaviours.WanderingBehaviour;
import game.actions.TalkAction;
import game.controllers.LoopingController;

public class Q extends Character{
    public Q() {
        super(new LoopingController(new WanderingBehaviour()), "Q", DisplayCharacters.Q, 4, 9999);
    }
    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        Actions tempActions = new Actions(new GivePlansAction(this));
        tempActions.add(new TalkAction(this));
        return tempActions;
    }

}
