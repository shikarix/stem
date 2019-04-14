package Engine;


import Engine.gfx.Image;
import StemGame.*;

import java.awt.image.DataBufferInt;

public class Renderer {
    public int pH, pW;
    public int p[];

    public Renderer(GameContainer gc) {
        pH = gc.heigth;
        pW = gc.width;
        p = ((DataBufferInt) gc.window.image.getRaster().getDataBuffer()).getData();
    }

    public void clear() {
//
//        for (int i = 0; i < p.length; i++) {
//            p[i] = i;
//        }
    }

    public void setPixel(int x, int y, int value) {
        if ((x < 0 || x > pW || y < 0 || y > pH) || value == 0xffff00ff) {
            return;
        }
        p[x + y * pW] = value;
    }

    public void drawImage(Image image, int offX, int offY) {
        int newX = 0;
        int newY = 0;
        int newWidth = image.w;
        int newHeight = image.h;

        if(offX < -newWidth) return;
        if(offY < -newHeight) return;
        if(offX >=pW) return;
        if(offY >= pH) return;

        if (offX < 0) {newX -= offX;}
        if (offY < 0) {newY -= offY;}
        if (newWidth + offX > pW) {newWidth -= (newWidth + offX - pW);}
        if (newHeight + offY > pH) {newHeight -= (newHeight + offY - pH);}

        for (int y = newY; y < newHeight; y++) {
            for (int x = newX; x < newWidth; x++) {
                setPixel(x + offX, y + offY, image.p[x + y * image.w]);
            }
        }
    }


    public void drawImage(Human h) {
        int newX = 0;
        int newY = 0;
        int newWidth = h.image.w;
        int newHeight = h.image.h;

        if(h.x < -newWidth) return;
        if(h.y < -newHeight) return;
        if(h.x >=pW) return;
        if(h.y >= pH) return;

        if (h.x < 0) {newX -= h.x;}
        if (h.y < 0) {newY -= h.y;}
        if (newWidth + h.y > pW) {newWidth -= (newWidth + h.x - pW);}
        if (newHeight + h.y > pH) {newHeight -= (newHeight + h.y - pH);}

        for (int y = newY; y < newHeight; y++) {
            for (int x = newX; x < newWidth; x++) {
                setPixel(x + h.x, y + h.y, h.image.p[x + y * h.image.w]);
            }
        }
    }

}

