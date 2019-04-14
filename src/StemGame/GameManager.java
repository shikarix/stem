package StemGame;


import Engine.AbstractGame;
import Engine.GameContainer;
import Engine.Renderer;
import Engine.gfx.Image;

import java.awt.event.KeyEvent;

public class GameManager extends AbstractGame {

    Player pl;
    Enemy enm;
    Enemy floor;
    Image fon;


    private int gravity = 1;

    int x = 0;
    int y = 0;


    public GameManager() {
        pl = new Player(new Image("human.jpg"), x, y);
        enm = new Enemy(new Image("enemy.jpg"), 500, 500);
        fon = new Image("picture2.png");
        floor = new Enemy(new Image("floor.jpg"), 0, 550);
    }

    boolean lockDown = false;
    boolean lockUp = false;
    boolean lockRight = false;
    boolean lockLeft = false;


    @Override
    public void update(GameContainer gc, float dt) {
        if (collision(pl, floor)) {
            lockDown = true;
        }
        else
        {
            lockDown = false;
        }

        if(collision(pl,enm))
        {
            enm.setVisible(false);
        }

        if(gc.input.isKeyDown(KeyEvent.VK_SPACE))
        {
            new Thread(() -> {
                for (int i = 0; i < 10;i++)
                {
                    y-=i;
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


//                    for (int i = 0; i < 10;i++)
//                    {
//                        y+=i;
//                        try {
//                            Thread.sleep(50);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
            }).start();
        }



        if (!lockUp) {
            if (gc.input.isKey(KeyEvent.VK_UP)) {
                y -= 1;
                System.out.println("UP!");
            }
        }

//        if (!lockDown) {
//            if (gc.input.isKey(KeyEvent.VK_DOWN)) {
//                y += 1;
//                System.out.println("Down!");
//            }
//        }

        if (!lockLeft) {
            if (gc.input.isKey(KeyEvent.VK_LEFT)) {
                x--;
                System.out.println("Left!");
            }
        }

        if (!lockRight)
            if (gc.input.isKey(KeyEvent.VK_RIGHT)) {

                x++;
                System.out.println("Right!");
            }
    }

    public boolean collision(Human A, Human B) {
        int objAMinX = A.x;
        int objAMaxX = A.x + A.image.w;
        int objAMinY = A.y;
        int objAMaxY = A.y + A.image.h;


        int objBMinX = B.x;
        int objBMaxX = B.x + B.image.w;
        int objBMinY = B.y;
        int objBMaxY = B.y + B.image.h;

        if (objAMaxX < objBMinX || objAMinX > objBMaxX) return false;
        if (objAMaxY < objBMinY || objAMinY > objBMaxY) return false;


        return true;
    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        r.drawImage(fon, 0, 0);
        r.drawImage(enm);
        r.drawImage(floor);
        pl.changePos(x, y);
        r.drawImage(pl);
    }

    public static void main(String[] args) {
        GameContainer gc = new GameContainer(new GameManager());
        gc.start();
    }
}
