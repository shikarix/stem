package Engine;

import java.awt.event.KeyEvent;

public class GameContainer implements Runnable {

    private Thread thread;
    public Window window;
    public Renderer renderer;
    public Input input;
    public AbstractGame game;



    public int width = 800;
    public int heigth = 600;
    public float scale = 1;
    public String title = "STEM_ENGINE 0.1";

    private boolean running = false;
    private final double UPDATE_CAP = 1.0 / 60.0;
    boolean render = false;
    double frameTime = 0;
    int frame = 0;
    int fps = 0;

    public GameContainer(AbstractGame game) {
        this.game = game;
    }

    public void start() {
        window = new Window(this);
        renderer = new Renderer(this);
        input = new Input(this);
        thread = new Thread(this);
        thread.run();
    }

    public void stop() {

    }

    public void run() {
        running = true;

        double firstTime = 0;
        double lastTime = System.nanoTime() / 1000000000.0;
        double passedTime = 0;
        double unprocessedTime = 0;

        while (running) {
            render = false;
            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            unprocessedTime += passedTime;
            frameTime += passedTime;

            while (unprocessedTime >= UPDATE_CAP) {
                unprocessedTime -= UPDATE_CAP;
                render = true;

                game.update(this, (float) UPDATE_CAP);

                input.update();

                if (frameTime >= 1.0) {
                    frameTime = 0;
                    fps = frame;
                    frame = 0;
                    System.out.println("FPS: " + fps);
                }

            }


            if (render) {
                renderer.clear();
                game.render(this,renderer);
                window.update();
                frame++;
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private void render() {

    }

    public void dispose() {

    }
}
