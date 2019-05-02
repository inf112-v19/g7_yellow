package inf112.roborally.app.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import inf112.roborally.app.card.programcard.IProgramCard;
import inf112.roborally.app.game.GameController;

public class CardUI {
    private ShapeRenderer render;
    private SpriteBatch batch;

    private final int CARD_HEIGHT = 100;
    private final int CARD_WIDTH = 75;

    public CardUI() {
        render = new ShapeRenderer();
        batch = new SpriteBatch();
    }

    public void drawPlayerCards() {
        int x = 20;
        int y = 20;
        int pId = GameController.playerTurn;
        for(IProgramCard c : GameController.players[pId].getCards()) {
            if (c != null)
                drawOneCard(c, x, y, (((x - 20) / 100)) == GameController.roundTurn - 1);
            x += 100;
        }
        x = 20;
        for (int i = 0; i < 5; i++) {
            drawCardGrid(x, y);
            x += 100;
        }
    }

    public void drawSelectCards() {

        int x = 50;
        int y = 400;
        int pId = GameController.playerTurn;
        for (IProgramCard c : GameController.players[pId].getSelectCards()) {
            if (c != null)
                drawOneCard(c, x, y, false);
            x += 100;
        }
        x = 50;
        for (int i = 0; i < 9; i++) {
            drawCardGrid(x, y);
            x += 100;
        }
    }

    public void drawOneCard(IProgramCard card, int x, int y, boolean first) {
        switch(card.toString()) {
            case("MoveCard 1"):
                drawForwardCard(x, y, first, 1);
                break;
            case("MoveCard 2"):
                drawForwardCard(x, y, first, 2);
                break;
            case("MoveCard 3"):
                drawForwardCard(x, y, first, 3);
                break;
            case("MoveCard -1"):
                drawBackwardsCard(x, y, first);
                break;
            case("RotateCard 90"):
                drawRotateLeftCard(x, y, first);
                break;
            case("RotateCard -90"):
                drawRotateRightCard(x, y, first);
                break;
            case("RotateCard 180"):
                drawFullRotateCard(x, y, first);
                break;
        }
    }

    public void drawForwardCard(int x, int y, boolean highighted, int amount) {
        drawCard(x,y, highighted);
        for (int i = 0; i < amount; i++) {
            drawArrow(i*20 + x + CARD_WIDTH / 2, y + CARD_HEIGHT / 3);
        }
    }

    public void drawBackwardsCard(int x, int y, boolean highlighted) {
        drawCard(x, y, highlighted);
        drawReverseArrow(x + CARD_WIDTH / 2, y + CARD_HEIGHT / 2);
    }

    public void drawRotateRightCard(int x, int y, boolean highlighted) {
        drawCard(x, y, highlighted);
        drawRotateRightArrow(x + CARD_WIDTH / 2, y + CARD_HEIGHT / 3);
    }

    public void drawRotateLeftCard(int x, int y, boolean highlighted) {
        drawCard(x, y, highlighted);
        drawRotateLeftArrow(x + CARD_WIDTH / 2, y + CARD_HEIGHT / 3);
    }

    public void drawFullRotateCard(int x, int y, boolean highlighted) {
        drawCard(x, y, highlighted);
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

    private void drawCard(int x, int y, boolean highighted) {
        render.begin(ShapeRenderer.ShapeType.Filled);
        render.setColor(0.7F, 0.7F, 0.7F, 0.6F); //GREY
        if (highighted)
            render.setColor(1,1,1,1);
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

    private void drawCardGrid(int x, int y) {
        render.begin(ShapeRenderer.ShapeType.Line);
        render.setColor(1F, 0f, 1F, 0.6F); //GREY
        render.rect(x, y, CARD_WIDTH, CARD_HEIGHT);
        render.end();
    }
}
