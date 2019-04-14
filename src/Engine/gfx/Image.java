package Engine.gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Image {
    public int h ,w;
    public  int p[];

    public Image(String path) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(Image.class.getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        h = image.getHeight();
        w = image.getWidth();
        p = image.getRGB(0,0,w,h,null,0,w);

        image.flush();
    }
}
