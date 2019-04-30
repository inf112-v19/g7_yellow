package inf112.roborally.app.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import static inf112.roborally.app.editor.Console.clear;

public class Menu implements Screen {

    private static Stage stage;
    private static TextField console;
    private ShapeRenderer sr;
    private static boolean active = true;
    private Table table;
    TextButton.TextButtonStyle style;

    public Menu() {

        sr = new ShapeRenderer();

        stage = new Stage(new ScreenViewport());

        table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);
        stage.setKeyboardFocus(table);
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        new Button.ButtonStyle();
        BitmapFont font = new BitmapFont();
        font.getData().setScale(2);
        style.font = font;
        style.fontColor = Color.RED;

        //create buttons
        TextButton newGame = new TextButton("New Game", style);
        TextButton preferences = new TextButton("Preferences", style);
        TextButton exit = new TextButton("Exit", style);

        //add buttons to table
        table.add(newGame).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(preferences).fillX().uniformX();
        table.row();
        table.add(exit).fillX().uniformX();

        newGame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });

        newGame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("newGame");

            }
        });

        preferences.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

            }
        });



    }


    public static boolean getActive() {
        return active;
    }

    public static void openCloseMenu() {
        try {
            active = !active;
            if (active) {
                clear();

            }
            if (!active);
        } catch (NullPointerException e) {
            //Ignore
        }
    }

    public void drawBox(int x, int y){
        sr.rect(x,y, 400, 100);
        sr.setColor(2,1,2,2);

    }

    @Override
    public void render(float v) {
        if(active && Main.gameState == GameState.MENU){
            stage.act();
            stage.draw();
        }

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

    @Override
    public void show() {

    }
}
