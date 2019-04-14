package StemGame;

import Engine.gfx.Image;

public class Enemy extends Human{

    private boolean visible = false;
    private int lastPosX;
    private int lastPosY;
    public Enemy(Image img, int x, int y) {
        this.image = img;
        this.x = x;
        this.y = y;
        this.visible = true;
    }

    public void changePos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setVisible(boolean arg)
    {
        this.visible = arg;
        this.lastPosX = this.x;
        this.lastPosY = this.y;
        this.x = -1000;
        this.y = -1000;
    }

    public boolean isVisible()
    {
        return visible;
    }
}
