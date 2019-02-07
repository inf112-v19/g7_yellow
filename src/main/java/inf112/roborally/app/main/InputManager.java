package inf112.roborally.app.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import inf112.roborally.app.player.Player;

public class InputManager {

    Player player;

    public InputManager(Player player) {
        this.player = player;
    }

    public void checkForInput() {
        if(Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            player.move(1,1);
        }
    }

}
