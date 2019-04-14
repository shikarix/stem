package flappyStem;

import Engine.AbstractGame;
import Engine.GameContainer;
import Engine.Renderer;
import Engine.gfx.Image;

import java.awt.event.KeyEvent;

public class GameManager extends AbstractGame {
    private Player player;
    private Column columnUp;
    private Column columnDown;
    private Image img;
    private boolean gravityBlock = false;
    private int gravity = 3;
    public int levelSpeed = 2;
    private int y;
    private int dynamicFonX = 0;

    public GameManager() {
        player = new Player(new Image("flappyStem/flappyPerson.png"), 50, 0, 1);
        img = new Image("flappyStem/flappyFon.png");
        columnUp = new Column(new Image("flappyStem/flappyColumn.png"), -100, -150);
        columnDown = new Column(new Image("flappyStem/FlappyColumn.png"), -100, columnUp.getY() + 600);
    }

    @Override
    public void update(GameContainer gc, float dt) {

    }

    @Override
    public void render(GameContainer gc, Renderer r) {

        if (dynamicFonX < -800) {
            dynamicFonX = 800;
        }
        r.drawImage(img, dynamicFonX -= levelSpeed, 0);
        if (dynamicFonX < 0) {
            r.drawImage(img, (dynamicFonX + 800), 0);
        } else {
            r.drawImage(img, (dynamicFonX - 800), 0);
        }

        if (columnUp.getX() + columnUp.getImg().w <= 0) {
            columnUp.setX(r.pW);
        } else {
            columnUp.setX(columnUp.getX() - levelSpeed);
        }
        r.drawImage(columnUp.getImg(), columnUp.getX(), columnUp.getY());


        if (columnDown.getX() + columnDown.getImg().w <= 0) {
            columnDown.setX(r.pW);
        } else {
            columnDown.setX(columnDown.getX() - levelSpeed);
        }
        r.drawImage(columnDown.getImg(), columnDown.getX(), columnDown.getY());


        if (player.getY() < r.pH || player.getY() + player.getImg().h > r.pH)
            r.drawImage(player.getImg(), player.getX(), player.getY());
        else {
            player.setY(r.pH / 2);
        }

    }

    public static void main(String[] args) {
        GameContainer gc = new GameContainer(new GameManager());
        gc.start();
    }
}
