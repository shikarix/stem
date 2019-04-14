package flappyStem;

import Engine.gfx.Image;

public class Column extends GameObjects {
    public Column(Image img, int x, int y)
    {
        this.setImg(img);
        this.setX(x);
        this.setY(y);
    }
}
