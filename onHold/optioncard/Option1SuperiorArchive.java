package inf112.roborally.app.card.optioncard;

import inf112.roborally.app.game.GameController;

public class Option1SuperiorArchive implements IOptionCard {
    @Override
    public int getId() {
        return 1;
    }

    @Override
    public String getName() {
        return "Superior Archive";
    }

    @Override
    public String description() {
        return "When reentering play after being destroyed, your robot doesn't receive the normal 2 Damage tokens.";
    }

    public void excecute(int robotID){
        /**
         * We could repair the robot if it's been respawned
         */
    }
}
