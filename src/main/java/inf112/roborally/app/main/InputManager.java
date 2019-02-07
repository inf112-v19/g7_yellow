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

        if(Gdx.input.isKeyJustPressed(Input.Keys.W))
            player.move(1,1);
        else if (Gdx.input.isKeyJustPressed(Input.Keys.S))
            player.move(-1,1);
        else if (Gdx.input.isKeyJustPressed(Input.Keys.D))
            player.rotate(1,1);
        else if (Gdx.input.isKeyJustPressed(Input.Keys.A))
            player.rotate(-1,1);
    }
}
