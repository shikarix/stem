package flappyStem;

import Engine.gfx.Image;

public abstract class GameObjects {
    private int x;
    private int y;
    private int w;
    private int h;
    private boolean visible;
    private Image img;


    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
}
