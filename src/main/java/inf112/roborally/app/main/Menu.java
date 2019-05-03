package inf112.roborally.app.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import inf112.roborally.app.editor.EditorInput;
import inf112.roborally.app.game.GameController;

import static inf112.roborally.app.editor.Console.clear;

public class Menu implements Screen {

    public static Stage stage = new Stage();

    private static boolean active = true;

    public Menu() {


        Table table = new Table();
        table.setFillParent(true);

        //shows lines
        //table.setDebug(true);
        stage.addActor(table);
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        new Button.ButtonStyle();
        BitmapFont font = new BitmapFont();
        font.getData().setScale(2);
        style.font = font;
        style.fontColor = Color.RED;
        labelStyle.font = font;
        labelStyle.fontColor = Color.RED;

        Texture robo = new Texture(Gdx.files.internal("src/main/resources/inf112/roborally/app/Menu/RoboMenu.png"));
        Texture editor = new Texture(Gdx.files.internal("src/main/resources/inf112/roborally/app/Menu/editor1.png"));
        Texture play = new Texture(Gdx.files.internal("src/main/resources/inf112/roborally/app/Menu/play3.png"));
        Texture exit = new Texture(Gdx.files.internal("src/main/resources/inf112/roborally/app/Menu/exit1.png"));


        ImageButton rr = new ImageButton(new TextureRegionDrawable(new TextureRegion(robo)));
        ImageButton playbutton = new ImageButton(new TextureRegionDrawable(new TextureRegion(play)));
        ImageButton editorbutton = new ImageButton(new TextureRegionDrawable(new TextureRegion(editor)));
        ImageButton exitbutton = new ImageButton(new TextureRegionDrawable(new TextureRegion(exit)));

        //adds buttons to table
        table.add(rr).center().size(600, 300);
        table.row().padBottom(10);
        table.add(playbutton).height(0).height(100).width(150);
        table.row().padBottom(10);
        table.add(editorbutton).height(0).height(100).width(150);
        table.row();
        table.add(exitbutton).height(0).height(100).width(150);

        playbutton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                Main.gameState = GameState.PLAYING;
                Gdx.input.setInputProcessor(null);
            }
        });

        editorbutton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Main.gameState = GameState.EDITOR;
                Gdx.input.setInputProcessor(null);
                EditorInput.enterEditorMode(null);
            }
        });

        exitbutton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                if(Main.gameState == GameState.MENU)
                    Gdx.app.exit();
            }
        });


        Gdx.input.setInputProcessor(stage);

    }

    public static void openMenu() {
        Gdx.input.setInputProcessor(stage);
        active = true;
    }

    @Override
    public void render(float v) {
        if (active && Main.gameState == GameState.MENU) {
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            stage.act();
            stage.draw();

        }
    }

    @Override
    public void resize(int i, int i1) {
        // As of now does nothing :)
    }

    @Override
    public void pause() {
        // As of now does nothing :)
    }

    @Override
    public void resume() {
        // As of now does nothing :)
    }

    @Override
    public void hide() {
        // As of now does nothing :)
    }

    @Override
    public void dispose() {
        // As of now does nothing :)
    }

    @Override
    public void show() {
        // As of now does nothing :)
    }
}
