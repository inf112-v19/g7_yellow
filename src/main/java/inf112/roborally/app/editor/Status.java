package inf112.roborally.app.editor;

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
import inf112.roborally.app.main.Main;

public class Status implements Screen {

    private static Stage stage;
    private static TextArea console;
    private static String status;
    private ShapeRenderer sr;

    public Status() {
        sr = new ShapeRenderer();
        stage = new Stage();

        TextField.TextFieldStyle style = new TextField.TextFieldStyle();
        BitmapFont font = new BitmapFont();
        font.getData().setScale(2f);
        style.font = font;
        style.fontColor = Color.YELLOW;
        console = new TextArea("Player", style);
        console.setPosition(15, Main.WINDOW_HEIGHT - 180);
        console.setSize(Main.WINDOW_WIDTH - 50, 150);
        stage.addActor(console);
        status = "USE (1-9) on your keyboard to select cards. \n" +
                 "BACKSPACE to reset cards and SPACE to continue";
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        console.setText("Player " + (GameController.playerTurn + 1) + "'s turn \n" +
                "Round: " + GameController.roundTurn + "\n"
        + status);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public static void setText(String s) {
        status = s;
    }
}
