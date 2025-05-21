/* 4a. Basic hello program of Swing displaying the message Hello! VI C , Welcome to Swing 
Programming in Blue color plain font with font size of  32  using Jframe and Jlabel */

import javax.swing.*;
import java.awt.*;

public class HelloSwing {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello Swing");
        frame.setSize(600, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hello! VI C, Welcome to Swing Programming", SwingConstants.CENTER);
        label.setForeground(Color.BLUE);
        label.setFont(new Font("Serif", Font.PLAIN, 32));

        frame.add(label);
        frame.setLocationRelativeTo(null); // Center on screen
        frame.setVisible(true);
    }
}
