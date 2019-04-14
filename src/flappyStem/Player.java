package flappyStem;

import Engine.gfx.Image;

public class Player extends GameObjects {
    private int health;

    public Player(Image img, int x, int y, int hp)
    {
        this.setImg(img);
        this.setX(x);
        this.setY(y);
        this.setHealth(hp);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

}
