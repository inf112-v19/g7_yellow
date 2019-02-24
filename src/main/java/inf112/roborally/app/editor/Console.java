package inf112.roborally.app.editor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import inf112.roborally.app.main.GameState;
import inf112.roborally.app.main.Main;

import java.util.StringTokenizer;

public class Console implements Screen {

    private static Stage stage;
    private static TextField console;
    private ShapeRenderer sr;
    private static boolean active = false;

    public Console() {
        sr = new ShapeRenderer();
        stage = new Stage();

        TextField.TextFieldStyle style = new TextField.TextFieldStyle();
        BitmapFont font = new BitmapFont();
        font.getData().setScale(2);
        style.font = font;
        style.fontColor = Color.RED;

        console = new TextField("", style);
        console.setPosition(15, Main.WINDOW_HEIGHT - 100);
        console.setSize(Main.WINDOW_WIDTH - 50,100);
        stage.addActor(console);
        Gdx.input.setInputProcessor(stage);
    }

    public static void clear() {
        console.setText("");
    }

    public static void execute() {
        StringTokenizer st = new StringTokenizer(console.getText());

        switch (st.nextToken()) {
            case ("savemap"):
                if (st.hasMoreTokens() && Main.gameState == GameState.EDITOR)
                    EditorInput.saveMap(st.nextToken());
                break;
            case ("loadmap"):
                if (st.hasMoreTokens())
                    EditorInput.loadMap(st.nextToken());
                break;
            case ("editor"):
                EditorInput.enterEditorMode();
                break;
            case ("exit"):
                System.exit(1);
        }
        clear();
    }

    public static boolean getActive() {
        return active;
    }

    public static void openCloseConsole() {
        active = !active;
        if(active) {
            clear();
            stage.setKeyboardFocus(console);
        }
        if(!active) stage.unfocusAll();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        if(!active) return;
        sr.begin(ShapeRenderer.ShapeType.Line);
        sr.setColor(1f,0f,0f,1);
        sr.rect(15,Main.WINDOW_HEIGHT-75,Main.WINDOW_WIDTH-50,50);
        sr.end();
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int i, int i1) { }

    @Override
    public void pause() { }

    @Override
    public void resume() { }

    @Override
    public void hide() { }

    @Override
    public void dispose() { }
}
