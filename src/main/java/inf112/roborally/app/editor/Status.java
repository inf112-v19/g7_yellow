package inf112.roborally.app.editor;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import inf112.roborally.app.game.GameController;
import inf112.roborally.app.main.GameState;
import inf112.roborally.app.main.Main;

public class Status implements Screen {

    private static Stage stage = new Stage();
    private TextArea console;
    private static String status = "USE (1-9) on your keyboard to select cards. \n" +
            "BACKSPACE to reset cards and SPACE to continue";

    public Status() {
        TextField.TextFieldStyle style = new TextField.TextFieldStyle();
        BitmapFont font = new BitmapFont();
        font.getData().setScale(1f);
        style.font = font;
        style.fontColor = Color.YELLOW;
        console = new TextArea("Player", style);
        console.setPosition(15, Main.WINDOW_HEIGHT - 180);
        console.setSize(Main.WINDOW_WIDTH - 50, 150);
        stage.addActor(console);
    }

    @Override
    public void show() {
        System.out.println("Not implemented");
    }

    @Override
    public void render(float v) {
        if(Main.gameState == GameState.PLAYING) {
            int turn = GameController.playerTurn+1;
            String robotData = null;
            if(GameController.getDamage(turn) > -1) robotData = "(Current damage = " + GameController.getDamage(turn);
            if(GameController.getRespawns(turn) > -1 && robotData != null) robotData += ", Respawns = " + GameController.getRespawns(turn) + ")";
            else if (GameController.getRespawns(turn) > -1 && GameController.getRespawns(turn) < 3) robotData = "(Respawns = " + GameController.getRespawns(turn) + ")";
            else robotData = "(DEAD)";
            console.setText("Player " + turn + "'s turn. \t" + robotData + "\n" +
                    "Round: " + GameController.roundTurn + "\n"+
                    "Flag: " + GameController.currentFlag(GameController.playerTurn+1) + "\n"
            + status);
            stage.act();
            stage.draw();
        }
    }

    @Override
    public void resize(int i, int i1) {
        System.out.println("Not implemented");
    }

    @Override
    public void pause() {
        System.out.println("Not implemented");
    }

    @Override
    public void resume() {
        System.out.println("Not implemented");
    }

    @Override
    public void hide() {
        System.out.println("Not implemented");
    }

    @Override
    public void dispose() {
        System.out.println("Not implemented");
    }

    public static void setText(String s) {
        status = s;
    }
}
