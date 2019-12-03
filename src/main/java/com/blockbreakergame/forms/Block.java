package com.blockbreakergame.forms;

        import java.awt.*;

public class Block extends Rectangle {

    public boolean powerUp = false;
    Image pic;
    int dx = 3;
    int dy = -3;
    Rectangle left;
    Rectangle right;

    boolean destroyed = false;

    public Block(int a, int b, int w, int h, String img) {
        x = a;
        y = b;
        width = w;
        height = h;
        left = new Rectangle(a-1,b, 1, h);
        right = new Rectangle(a+w+1, b, 1, h);

        pic = Toolkit.getDefaultToolkit().getImage(Block.class.getResource(img));
    }

    public void draw(Graphics g, Component c){
        if(!destroyed)
        g.drawImage(pic, x, y, width, height, c);
    }



}
