package inf112.roborally.app.card.optioncard;

import inf112.roborally.app.game.GameController;

public class Option2ReverseGear implements IOptionCard{
    @Override
    public int getId() {
        return 2;
    }

    @Override
    public String getName() {
        return "Reverse Gear";
    }

    @Override
    public String description() {
        return "Whenever you execute a Back Up, you may move your robot back 2 spaces instead of 1." +
                "Priority is that of the Back Up.";
    }

    public void excecute(int robotID){
        GameController.moveRobot(robotID, -2);
    }
}
