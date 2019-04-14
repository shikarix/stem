package Engine;

import Engine.GameContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Window {

    public JFrame frame;
    public BufferedImage image;
    public Canvas canvas;
    public BufferStrategy bufferStrategy;
    public Graphics g;

    public Window(GameContainer gc) {
        image = new BufferedImage(gc.width, gc.heigth, BufferedImage.TYPE_INT_RGB);
        canvas = new Canvas();
        Dimension s = new Dimension((int) (gc.width * gc.scale) , (int) (gc.heigth * gc.scale));
        canvas.setPreferredSize(s);
        canvas.setMinimumSize(s);
        canvas.setMaximumSize(s);

        frame = new JFrame(gc.title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(canvas,BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        g = bufferStrategy.getDrawGraphics();
    }

    public void update()
    {
        g.drawImage(image, 0,0,canvas.getWidth(),canvas.getHeight(),null);
        bufferStrategy.show();
    }
}
