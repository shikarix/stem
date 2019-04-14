package StemGame;

import Engine.gfx.Image;

public class Player extends Human {

    public Player(Image img, int x, int y) {
        this.image = img;
        this.x = x;
        this.y = y;
    }

    public void changePos(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
