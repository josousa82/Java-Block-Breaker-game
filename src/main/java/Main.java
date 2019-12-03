import com.blockbreakergame.forms.BlockBreakerPanel;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Block Breaker");

        BlockBreakerPanel panel = new BlockBreakerPanel();

        //adding panels to frame
        frame.getContentPane().add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(504,600);
        frame.setResizable(false);




    }
   
    
}
