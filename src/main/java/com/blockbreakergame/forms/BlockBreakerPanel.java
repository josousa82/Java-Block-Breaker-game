package com.blockbreakergame.forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class BlockBreakerPanel extends JPanel implements KeyListener {

    ArrayList<Block> blocks = new ArrayList<>();
    ArrayList<Block> ball = new ArrayList<>();

    Block paddle;
    Thread thread;
    Animate animate;

    public BlockBreakerPanel()  {

        paddle = new Block(175,480,150,25,"/img/PNG/17-Breakout-paddle.png");

       createLineBlocks(0,"/img/PNG/01-Breakout-Tiles-blue.png");
       createLineBlocks(25,"/img/PNG/03-Breakout-Tiles-green.png");
       createLineBlocks(50, "/img/PNG/05-Breakout-Tiles-rouge.png");
       createLineBlocks(75, "/img/PNG/07-Breakout-Tiles-red.png");

       addKeyListener(this);
       setFocusable(true);

    }

    private void createLineBlocks(int verticalPosition, String fileResourcePath){
        for (int i = 0; i < 10 ; i++) {
            blocks.add(new Block((i*50+2), verticalPosition,50, 25, fileResourcePath));
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for(Block b : blocks) {

            b.draw(g, this);
            paddle.draw(g, this);
        }
    }


    public void update(){
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            animate = new Animate(this);
            thread = new Thread(animate);
            thread.start();
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT && paddle.x > 0 ){
            paddle.x -= 15;
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT && paddle.x <(getWidth() - paddle.width)){
            paddle.x += 15;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
