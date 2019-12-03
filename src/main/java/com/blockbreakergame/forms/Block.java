package com.blockbreakergame.forms;

        import java.awt.*;

public class Block extends Rectangle {

    Image pic;

    public Block(int a, int b, int w, int h, String img) {
        x = a;
        y = b;
        width = w;
        height = h;
        pic = Toolkit.getDefaultToolkit().getImage(Block.class.getResource(img));
    }

    public void draw(Graphics g, Component c){

        g.drawImage(pic, x, y, width, height, c);
    }


}
