package inf112.roborally.app.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import static inf112.roborally.app.editor.Console.clear;

public class Menu implements Screen {

    public static Stage stage;

    private static boolean active = true;
    private Table table;
    private BitmapFont font;

    public Menu() {

        stage = new Stage();
        table = new Table();
        table.setFillParent(true);
        //table.setDebug(true);
        stage.addActor(table);

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        new Button.ButtonStyle();
        font = new BitmapFont();
        font.getData().setScale(2);
        style.font = font;
        style.fontColor = Color.RED;
        labelStyle.font = font;
        labelStyle.fontColor = Color.RED;

        Label roborally = new Label("RoboRally", labelStyle);
        roborally.setPosition((Main.WINDOW_WIDTH / 2) - 70,(Main.WINDOW_HEIGHT) - 300);
        stage.addActor(roborally);

        //create buttons
        TextButton newGame = new TextButton("Play", style);
        TextButton editor = new TextButton("Editor", style);
        TextButton exit = new TextButton("Exit", style);

        //add to table
        table.add(newGame);
        table.row();
        table.add(editor);
        table.row();
        table.add(exit);

        newGame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                Main.gameState = GameState.PLAYING;
            }
        });

        editor.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Main.gameState = GameState.EDITOR;
            }
        });

        exit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                Gdx.app.exit();
            }
        });

        Gdx.input.setInputProcessor(stage);



    }


    @Override
    public void render(float v) {
        if(active && Main.gameState == GameState.MENU){
            stage.act();
            stage.draw();
        }
    }


    public static void openMenu() {
       active = true;
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
