package inf112.roborally.app.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class CardUI {
    private ShapeRenderer render;
    private SpriteBatch batch;

    private final int CARD_HEIGHT = 100;
    private final int CARD_WIDTH = 75;

    public CardUI() {
        render = new ShapeRenderer();
        batch = new SpriteBatch();
    }

    public void drawForwardCard(int x, int y) {
        drawCard(x,y);
        drawArrow(x + CARD_WIDTH / 2, y + CARD_HEIGHT / 3);
    }

    public void drawBackwardsCard(int x, int y) {
        drawCard(x, y);
        drawReverseArrow(x + CARD_WIDTH / 2, y + CARD_HEIGHT / 2);
    }

    public void drawRotateRightCard(int x, int y) {
        drawCard(x, y);
        drawRotateRightArrow(x + CARD_WIDTH / 2, y + CARD_HEIGHT / 3);
    }

    public void drawRotateLeftCard(int x, int y) {
        drawCard(x, y);
        drawRotateLeftArrow(x + CARD_WIDTH / 2, y + CARD_HEIGHT / 3);
    }

    public void drawFullRotateCard(int x, int y) {
        drawCard(x, y);
        drawFullRotateArrow(x + CARD_WIDTH / 2, y + CARD_HEIGHT / 3);
    }

    private void drawRotateRightArrow(int x, int y) {
        render.begin(ShapeRenderer.ShapeType.Filled);
        render.setColor(1F, 0F, 0F, 1F); //GREY
        render.arc(x, y, 40, 90, 90);
        render.setColor(1F, 1F, 1F, 0.6F); //GREY
        render.arc(x, y, 20, 90, 90);
        render.setColor(1F, 0F, 0F, 1F); //GREY
        render.triangle(x, y + 45 + 10, x, y, x + 20, y + 25);
        render.end();
    }

    private void drawRotateLeftArrow(int x, int y) {
        render.begin(ShapeRenderer.ShapeType.Filled);
        render.setColor(1F, 0F, 0F, 1F); //GREY
        render.arc(x, y, 40, 0, 90);
        render.setColor(1F, 1F, 1F, 0.6F); //GREY
        render.arc(x, y, 20, 0, 90);
        render.setColor(1F, 0F, 0F, 1F); //GREY
        render.triangle(x, y + 45 + 10, x, y, x - 20, y + 25);
        render.end();
    }

    private void drawFullRotateArrow(int x, int y) {
        render.begin(ShapeRenderer.ShapeType.Filled);
        render.setColor(1F, 0F, 0F, 1F); //GREY
        render.arc(x, y, 35, 0, 180);
        render.setColor(1F, 1F, 1F, 0.6F); //GREY
        render.arc(x, y, 15, 0, 180);
        render.setColor(1F, 0F, 0F, 1F); //GREY
        render.triangle(x + 25, y - 25, x + 20 + 25, y, x - 20 + 25, y);
        render.end();
    }

    private void drawCard(int x, int y) {
        render.begin(ShapeRenderer.ShapeType.Filled);
        render.setColor(1F, 1F, 1F, 0.6F); //GREY
        render.rect(x, y, CARD_WIDTH, CARD_HEIGHT);
        render.end();
    }

    private void drawArrow(int x, int y) {
        render.begin(ShapeRenderer.ShapeType.Filled);
        render.setColor(1F, 0f, 0f, 1f); //GREY
        render.rect(x - 10f, y - 15f, 20, 30);
        render.triangle(x - 20, y + 15, x + 20, y + 15, x, y + 45f);
        render.end();
    }

    private void drawReverseArrow(int x, int y) {
        render.begin(ShapeRenderer.ShapeType.Filled);
        render.setColor(1F, 0f, 0f, 1f); //GREY
        render.rect(x - 10f, y - 15f, 20, 30);
        render.triangle(x - 20, y - 15, x + 20, y - 15, x, y - 45f);
        render.end();
    }
}
