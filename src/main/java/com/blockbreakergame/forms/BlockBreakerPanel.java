package com.blockbreakergame.forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class BlockBreakerPanel extends JPanel implements KeyListener {

    ArrayList<Block> blocks = new ArrayList<>();
    ArrayList<Block> ball = new ArrayList<>();
    ArrayList<Block> powerUp = new ArrayList<>();

    Block paddle;
    Thread thread;
    Animate animate;

    int size = 25;

    public BlockBreakerPanel()  {

        paddle = new Block(175,480,150,25,"/img/PNG/17-Breakout-paddle.png");

       createLineBlocks(0,"/img/PNG/01-Breakout-Tiles-blue.png");
       createLineBlocks(25,"/img/PNG/03-Breakout-Tiles-green.png");
       createLineBlocks(50, "/img/PNG/05-Breakout-Tiles-rouge.png");
       createLineBlocks(75, "/img/PNG/07-Breakout-Tiles-red.png");
       Random random = new Random();
       blocks.get(random.nextInt(40)).powerUp = true;


       createBall("/img/PNG/58-Ball-Tiles.png");

       addKeyListener(this);
       setFocusable(true);



    }

    private void createLineBlocks(int verticalPosition, String fileResourcePath){
        for (int i = 0; i < 10 ; i++) {
            blocks.add(new Block((i*50+2), verticalPosition,50, 25, fileResourcePath));
        }
    }

    private void createBall(String img){
        ball.add(new Block(237, 437, 25, 25, img));
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        for(Block b : blocks) {
            b.draw(g, this);
        }

        for(Block b: ball) {
            b.draw(g, this);
        }

        for(Block p : powerUp){
            p.draw(g, this);
        }

        paddle.draw(g, this);

    }


    public void update(){

        for(Block p : powerUp){
             p.y += 1;
        }

        for(Block ba : ball){
            ba.x+=ba.dx;

           if(ba.x > (getWidth() - size) && ba.dx > 0 || ba.x < 0){
                ba.dx *= -1;
            }
            if (ba.y < 0 || ba.intersects(paddle)){
                ba.dy *= -1;
            }
            ba.y+=ba.dy;

            for (Block b : blocks){
                if(b.left.intersects(ba) || b.right.intersects(ba) && !b.destroyed){
                    ba.dx *= -1;
                    b.destroyed = true;
                    if(b.powerUp){
                        powerUp.add(new Block(b.x, b.y, 25, 19, "/img/PNG/59-star-Tiles.png"));
                    }
                }else if(ba.intersects(b) && !b.destroyed){
                    b.destroyed = true;
                    ba.dy*=-1;
                    if(b.powerUp){
                        powerUp.add(new Block(b.x, b.y, 25, 19, "/img/PNG/59-star-Tiles.png"));
                    }
                }
            }
        }


        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        updateKey(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {

        updateKey(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        updateKey(e);

    }

    public void updateKey(KeyEvent ev){
        if(ev.getKeyCode() == KeyEvent.VK_ENTER){
            animate = new Animate(this);
            thread = new Thread(animate);
            thread.start();
        }

        if(ev.getKeyCode() == KeyEvent.VK_LEFT && paddle.x > 0 ){
            paddle.x -= 10;
        }

        if(ev.getKeyCode() == KeyEvent.VK_RIGHT && paddle.x <(getWidth() - paddle.width)){
            paddle.x += 10;
        }
    }
}
