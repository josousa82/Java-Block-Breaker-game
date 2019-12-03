package com.blockbreakergame.forms;

public class Animate implements Runnable {
    BlockBreakerPanel blockBreakerPanel;

    public Animate(BlockBreakerPanel blockBreakerPanel) {

        this.blockBreakerPanel = blockBreakerPanel;
    }

    @Override
    public void run() {
        while(true){
            blockBreakerPanel.update();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
